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

package com.rpkit.chat.bukkit.event.chatchannel

import com.rpkit.chat.bukkit.chatchannel.RPKChatChannel
import com.rpkit.core.bukkit.event.RPKBukkitEvent
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfile
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList


class RPKBukkitChatChannelSwitchEvent(
        override val minecraftProfile: RPKMinecraftProfile,
        override val oldChannel: RPKChatChannel?,
        override var chatChannel: RPKChatChannel?
) : RPKBukkitEvent(), RPKChatChannelSwitchEvent, Cancellable {

    companion object {
        @JvmStatic
        val handlerList = HandlerList()
    }

    private var cancel: Boolean = false

    override fun isCancelled(): Boolean {
        return cancel
    }

    override fun setCancelled(cancel: Boolean) {
        this.cancel = cancel
    }

    override fun getHandlers(): HandlerList {
        return handlerList
    }

}