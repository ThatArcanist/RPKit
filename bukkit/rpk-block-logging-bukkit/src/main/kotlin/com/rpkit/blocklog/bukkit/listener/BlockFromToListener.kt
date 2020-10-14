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

package com.rpkit.blocklog.bukkit.listener

import com.rpkit.blocklog.bukkit.RPKBlockLoggingBukkit
import com.rpkit.blocklog.bukkit.block.RPKBlockChangeImpl
import com.rpkit.blocklog.bukkit.block.RPKBlockHistoryService
import com.rpkit.core.service.Services
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority.MONITOR
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockFromToEvent
import java.time.LocalDateTime


class BlockFromToListener(private val plugin: RPKBlockLoggingBukkit) : Listener {

    @EventHandler(priority = MONITOR)
    fun onBlockFromTo(event: BlockFromToEvent) {
        val blockHistoryService = Services[RPKBlockHistoryService::class]
        if (blockHistoryService == null) {
            plugin.logger.severe("Failed to retrieve block history service, did the plugin load correctly?")
            return
        }
        val blockHistory = blockHistoryService.getBlockHistory(event.block)
        val blockChange = RPKBlockChangeImpl(
                blockHistory = blockHistory,
                time = LocalDateTime.now(),
                profile = null,
                minecraftProfile = null,
                character = null,
                from = event.toBlock.type,
                to = event.block.type,
                reason = "FROM_TO"
        )
        blockHistoryService.addBlockChange(blockChange)
    }

}