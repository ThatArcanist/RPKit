/*
 * Copyright 2021 Ren Binden
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.payments.bukkit.database.table

import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.core.service.Services
import com.rpkit.economy.bukkit.currency.RPKCurrencyId
import com.rpkit.economy.bukkit.currency.RPKCurrencyService
import com.rpkit.payments.bukkit.RPKPaymentsBukkit
import com.rpkit.payments.bukkit.database.create
import com.rpkit.payments.bukkit.database.jooq.Tables.RPKIT_PAYMENT_GROUP
import com.rpkit.payments.bukkit.group.RPKPaymentGroup
import com.rpkit.payments.bukkit.group.RPKPaymentGroupImpl
import java.time.Duration
import java.time.temporal.ChronoUnit.MILLIS

/**
 * Represents payment group table.
 */
class RPKPaymentGroupTable(
        private val database: Database,
        private val plugin: RPKPaymentsBukkit
) : Table {

    private val cache = if (plugin.config.getBoolean("caching.rpkit_payment_group.id.enabled")) {
        database.cacheManager.createCache(
            "rpk-payments-bukkit.rpkit_payment_group.id",
            Int::class.javaObjectType,
            RPKPaymentGroup::class.java,
            plugin.config.getLong("caching.rpkit_payment_group.id.size")
        )
    } else {
        null
    }

    fun insert(entity: RPKPaymentGroup) {
        database.create
                .insertInto(
                        RPKIT_PAYMENT_GROUP,
                        RPKIT_PAYMENT_GROUP.NAME,
                        RPKIT_PAYMENT_GROUP.AMOUNT,
                        RPKIT_PAYMENT_GROUP.CURRENCY_ID,
                        RPKIT_PAYMENT_GROUP.INTERVAL,
                        RPKIT_PAYMENT_GROUP.LAST_PAYMENT_TIME,
                        RPKIT_PAYMENT_GROUP.BALANCE
                )
                .values(
                        entity.name,
                        entity.amount,
                        entity.currency?.id?.value,
                        entity.interval.toMillis(),
                        entity.lastPaymentTime,
                        entity.balance
                )
                .execute()
        val id = database.create.lastID().toInt()
        entity.id = id
        cache?.set(id, entity)
    }

    fun update(entity: RPKPaymentGroup) {
        val id = entity.id ?: return
        database.create
                .update(RPKIT_PAYMENT_GROUP)
                .set(RPKIT_PAYMENT_GROUP.NAME, entity.name)
                .set(RPKIT_PAYMENT_GROUP.AMOUNT, entity.amount)
                .set(RPKIT_PAYMENT_GROUP.CURRENCY_ID, entity.currency?.id?.value)
                .set(RPKIT_PAYMENT_GROUP.INTERVAL, entity.interval.toMillis())
                .set(RPKIT_PAYMENT_GROUP.LAST_PAYMENT_TIME, entity.lastPaymentTime)
                .set(RPKIT_PAYMENT_GROUP.BALANCE, entity.balance)
                .where(RPKIT_PAYMENT_GROUP.ID.eq(id))
                .execute()
        cache?.set(id, entity)
    }

    operator fun get(id: Int): RPKPaymentGroup? {
        if (cache?.containsKey(id) == true) {
            return cache[id]
        } else {
            val result = database.create
                    .select(
                            RPKIT_PAYMENT_GROUP.NAME,
                            RPKIT_PAYMENT_GROUP.AMOUNT,
                            RPKIT_PAYMENT_GROUP.CURRENCY_ID,
                            RPKIT_PAYMENT_GROUP.INTERVAL,
                            RPKIT_PAYMENT_GROUP.LAST_PAYMENT_TIME,
                            RPKIT_PAYMENT_GROUP.BALANCE
                    )
                    .from(RPKIT_PAYMENT_GROUP)
                    .where(RPKIT_PAYMENT_GROUP.ID.eq(id))
                    .fetchOne()
            val currencyService = Services[RPKCurrencyService::class.java] ?: return null
            val currencyId = result.get(RPKIT_PAYMENT_GROUP.CURRENCY_ID)
            val currency = if (currencyId == null) null else currencyService.getCurrency(RPKCurrencyId(currencyId))
            val paymentGroup = RPKPaymentGroupImpl(
                    plugin,
                    id,
                    result.get(RPKIT_PAYMENT_GROUP.NAME),
                    result.get(RPKIT_PAYMENT_GROUP.AMOUNT),
                    currency,
                    Duration.of(result.get(RPKIT_PAYMENT_GROUP.INTERVAL), MILLIS),
                    result.get(RPKIT_PAYMENT_GROUP.LAST_PAYMENT_TIME),
                    result.get(RPKIT_PAYMENT_GROUP.BALANCE)
            )
            cache?.set(id, paymentGroup)
            return paymentGroup
        }
    }

    fun get(name: String): RPKPaymentGroup? {
        val result = database.create
                .select(RPKIT_PAYMENT_GROUP.ID)
                .from(RPKIT_PAYMENT_GROUP)
                .where(RPKIT_PAYMENT_GROUP.NAME.eq(name))
                .fetchOne() ?: return null
        return get(result.get(RPKIT_PAYMENT_GROUP.ID))
    }

    fun getAll(): List<RPKPaymentGroup> {
        val results = database.create
                .select(RPKIT_PAYMENT_GROUP.ID)
                .from(RPKIT_PAYMENT_GROUP)
                .fetch()
        return results.map { result -> get(result.get(RPKIT_PAYMENT_GROUP.ID)) }
                .filterNotNull()
    }

    fun delete(entity: RPKPaymentGroup) {
        val id = entity.id ?: return
        database.create
                .deleteFrom(RPKIT_PAYMENT_GROUP)
                .where(RPKIT_PAYMENT_GROUP.ID.eq(id))
                .execute()
        cache?.remove(id)
    }

}