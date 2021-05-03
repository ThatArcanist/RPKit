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

package com.rpkit.chat.bukkit.command.chatgroup

import com.rpkit.chat.bukkit.RPKChatBukkit
import com.rpkit.chat.bukkit.chatgroup.RPKChatGroupName
import com.rpkit.chat.bukkit.chatgroup.RPKChatGroupService
import com.rpkit.core.service.Services
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfileService
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Chat group leave command.
 * Leaves a chat group.
 */
class ChatGroupLeaveCommand(private val plugin: RPKChatBukkit) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.hasPermission("rpkit.chat.command.chatgroup.leave")) {
            sender.sendMessage(plugin.messages["no-permission-chat-group-leave"])
            return true
        }
        if (args.isEmpty()) {
            sender.sendMessage(plugin.messages["chat-group-leave-usage"])
            return true
        }
        val minecraftProfileService = Services[RPKMinecraftProfileService::class.java]
        if (minecraftProfileService == null) {
            sender.sendMessage(plugin.messages["no-minecraft-profile-service"])
            return true
        }
        val chatGroupService = Services[RPKChatGroupService::class.java]
        if (chatGroupService == null) {
            sender.sendMessage(plugin.messages["no-chat-group-service"])
            return true
        }
        chatGroupService.getChatGroup(RPKChatGroupName(args[0])).thenAccept { chatGroup ->
            if (chatGroup == null) {
                sender.sendMessage(plugin.messages["chat-group-leave-invalid-chat-group"])
                return@thenAccept
            }
            if (sender !is Player) {
                sender.sendMessage(plugin.messages["not-from-console"])
                return@thenAccept
            }
            val minecraftProfile = minecraftProfileService.getPreloadedMinecraftProfile(sender)
            if (minecraftProfile == null) {
                sender.sendMessage(plugin.messages["no-minecraft-profile"])
                return@thenAccept
            }
            chatGroup.members.thenAccept getMembers@{ members ->
                if (members.none { memberMinecraftProfile ->
                        memberMinecraftProfile.id == minecraftProfile.id
                    }) {
                    sender.sendMessage(plugin.messages["chat-group-leave-invalid-not-a-member"])
                    return@getMembers
                }
                plugin.server.scheduler.runTask(plugin, Runnable {
                    chatGroup.removeMember(minecraftProfile).thenRun {
                        chatGroup.members.thenAccept newMembers@{ newMembers ->
                            if (newMembers.isEmpty()) {
                                plugin.server.scheduler.runTask(plugin, Runnable {
                                    chatGroupService.removeChatGroup(chatGroup)
                                })
                            }
                            sender.sendMessage(plugin.messages["chat-group-leave-valid", mapOf(
                                "group" to chatGroup.name.value
                            )])
                        }
                    }
                })
            }
        }

        return true
    }

}