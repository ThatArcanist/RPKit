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

package com.rpkit.locks.bukkit.listener

import com.rpkit.core.service.Services
import com.rpkit.locks.bukkit.RPKLocksBukkit
import com.rpkit.locks.bukkit.lock.RPKLockService
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent


class CraftItemListener(private val plugin: RPKLocksBukkit) : Listener {

    @EventHandler
    fun onCraftItem(event: CraftItemEvent) {
        val lockService = Services[RPKLockService::class]
        if (lockService == null) {
            event.whoClicked.sendMessage(plugin.messages["no-lock-service"])
            return
        }
        for (item in event.inventory.contents) {
            if (item == null) continue
            if (!lockService.isKey(item)) continue
            event.isCancelled = true
            event.whoClicked.sendMessage(plugin.messages["crafting-no-keys"])
        }
    }
}