package com.rpkit.permissions.bukkit.command.group

import com.rpkit.core.command.RPKCommandExecutor
import com.rpkit.core.command.result.*
import com.rpkit.core.command.sender.RPKCommandSender
import com.rpkit.core.service.Services
import com.rpkit.permissions.bukkit.RPKPermissionsBukkit
import com.rpkit.permissions.bukkit.group.RPKGroup
import com.rpkit.permissions.bukkit.group.RPKGroupName
import com.rpkit.permissions.bukkit.group.RPKGroupService
import com.rpkit.players.bukkit.command.result.InvalidTargetMinecraftProfileFailure
import com.rpkit.players.bukkit.command.result.NoMinecraftProfileOtherFailure
import com.rpkit.players.bukkit.command.result.NoProfileOtherFailure
import com.rpkit.players.bukkit.profile.RPKProfile
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfileService

class GroupSwitchPriorityCommand(private val plugin: RPKPermissionsBukkit) : RPKCommandExecutor {

    class InvalidGroupFailure : CommandFailure()
    class GroupNotPresentFailure(val group: RPKGroup): CommandFailure()

    override fun onCommand(sender: RPKCommandSender, args: Array<out String>): CommandResult {
        if (!sender.hasPermission("rpkit.permissions.command.group.switchpriority")) {
            sender.sendMessage(plugin.messages.noPermissionGroupSwitchPriority)
            return NoPermissionFailure("rpkit.permissions.command.group.switchpriority")
        }
        val minecraftProfileService = Services[RPKMinecraftProfileService::class.java]
        if (minecraftProfileService == null) {
            sender.sendMessage(plugin.messages.noMinecraftProfileService)
            return MissingServiceFailure(RPKMinecraftProfileService::class.java)
        }
        if (args.size < 3) {
            sender.sendMessage(plugin.messages.groupSwitchPriorityUsage)
            return IncorrectUsageFailure()
        }
        val targetBukkitPlayer = plugin.server.getPlayer(args[0])
        if (targetBukkitPlayer == null) {
            sender.sendMessage(plugin.messages.groupSwitchPriorityInvalidTarget)
            return InvalidTargetMinecraftProfileFailure()
        }
        val targetMinecraftProfile = minecraftProfileService.getMinecraftProfile(targetBukkitPlayer)
        if (targetMinecraftProfile == null) {
            sender.sendMessage(plugin.messages.noMinecraftProfileOther)
            return NoMinecraftProfileOtherFailure()
        }
        val targetProfile = targetMinecraftProfile.profile
        if (targetProfile !is RPKProfile) {
            sender.sendMessage(plugin.messages.noProfile)
            return NoProfileOtherFailure()
        }
        val groupService = Services[RPKGroupService::class.java]
        if (groupService == null) {
            sender.sendMessage(plugin.messages.noGroupService)
            return MissingServiceFailure(RPKGroupService::class.java)
        }
        val group1 = groupService.getGroup(RPKGroupName(args[1]))
        if (group1 == null) {
            sender.sendMessage(plugin.messages.groupSwitchPriorityInvalidGroup.withParameters(
                groupName = args[1]
            ))
            return InvalidGroupFailure()
        }
        val group2 = groupService.getGroup(RPKGroupName(args[2]))
        if (group2 == null) {
            sender.sendMessage(plugin.messages.groupSwitchPriorityInvalidGroup.withParameters(
                groupName = args[2]
            ))
            return InvalidGroupFailure()
        }
        val group1Priority = groupService.getGroupPriority(targetProfile, group1)
        if (group1Priority == null) {
            sender.sendMessage(plugin.messages.groupSwitchPriorityInvalidGroupNotPresent.withParameters(
                profile = targetProfile,
                group = group1
            ))
            return GroupNotPresentFailure(group1)
        }
        val group2Priority = groupService.getGroupPriority(targetProfile, group2)
        if (group2Priority == null) {
            sender.sendMessage(plugin.messages.groupSwitchPriorityInvalidGroupNotPresent.withParameters(
                profile = targetProfile,
                group = group2
            ))
            return GroupNotPresentFailure(group2)
        }
        groupService.setGroupPriority(targetProfile, group1, group2Priority)
        groupService.setGroupPriority(targetProfile, group2, group1Priority)
        sender.sendMessage(plugin.messages.groupSwitchPriorityValid.withParameters(
            profile = targetProfile,
            group1 = group1,
            group2 = group2
        ))
        return CommandSuccess
    }

}