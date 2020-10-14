/*
 * Copyright 2020 Ren Binden
 *
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

package com.rpkit.economy.bukkit.database.table

import com.rpkit.characters.bukkit.character.RPKCharacter
import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.economy.bukkit.RPKEconomyBukkit
import com.rpkit.economy.bukkit.character.RPKMoneyHidden
import com.rpkit.economy.bukkit.database.jooq.Tables.RPKIT_MONEY_HIDDEN
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder

/**
 * Represents the money hidden table.
 */
class RPKMoneyHiddenTable(
        private val database: Database,
        plugin: RPKEconomyBukkit
) : Table {

    private val characterCache = if (plugin.config.getBoolean("caching.rpkit_money_hidden.character_id.enabled")) {
        database.cacheManager.createCache("rpk-economy-bukkit.rpkit_money_hidden.character_id",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Int::class.javaObjectType,
                        RPKMoneyHidden::class.java,
                        ResourcePoolsBuilder.heap(
                                plugin.config.getLong("caching.rpkit_money_hidden.character_id.size")
                        )
                ).build()
        )
    } else {
        null
    }

    fun insert(entity: RPKMoneyHidden) {
        database.create
                .insertInto(
                        RPKIT_MONEY_HIDDEN,
                        RPKIT_MONEY_HIDDEN.CHARACTER_ID
                )
                .values(
                        entity.character.id
                )
                .execute()
        characterCache?.put(entity.character.id, entity)
    }

    /**
     * Gets the money hidden instance for a character.
     * If there is no money hidden row for the character, null is returned.
     *
     * @param character The character
     * @return The money hidden instance, or null if there is no money hidden instance for the character
     */
    operator fun get(character: RPKCharacter): RPKMoneyHidden? {
        if (characterCache?.containsKey(character.id) == true) {
            return characterCache[character.id]
        } else {
            database.create
                    .select(RPKIT_MONEY_HIDDEN.CHARACTER_ID)
                    .from(RPKIT_MONEY_HIDDEN)
                    .where(RPKIT_MONEY_HIDDEN.CHARACTER_ID.eq(character.id))
                    .fetchOne() ?: return null
            val moneyHidden = RPKMoneyHidden(character)
            characterCache?.put(character.id, moneyHidden)
            return moneyHidden
        }
    }

    fun delete(entity: RPKMoneyHidden) {
        database.create
                .deleteFrom(RPKIT_MONEY_HIDDEN)
                .where(RPKIT_MONEY_HIDDEN.CHARACTER_ID.eq(entity.character.id))
                .execute()
        characterCache?.remove(entity.character.id)
    }

}
