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

package com.rpkit.players.bukkit.event.githubprofile

import com.rpkit.core.bukkit.event.RPKBukkitEvent
import com.rpkit.players.bukkit.profile.github.RPKGitHubProfile
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList


class RPKBukkitGitHubProfileCreateEvent(
        override val githubProfile: RPKGitHubProfile
) : RPKBukkitEvent(), RPKGitHubProfileCreateEvent, Cancellable {

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