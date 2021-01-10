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

package com.rpkit.economy.bukkit.command.money

import com.rpkit.characters.bukkit.character.RPKCharacter
import com.rpkit.characters.bukkit.character.RPKCharacterService
import com.rpkit.core.service.Services
import com.rpkit.economy.bukkit.RPKEconomyBukkit
import com.rpkit.economy.bukkit.currency.RPKCurrency
import com.rpkit.economy.bukkit.currency.RPKCurrencyName
import com.rpkit.economy.bukkit.currency.RPKCurrencyService
import com.rpkit.economy.bukkit.economy.RPKEconomyService
import com.rpkit.players.bukkit.profile.RPKProfile
import com.rpkit.players.bukkit.profile.RPKProfileService
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfileService
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.conversations.ConversationContext
import org.bukkit.conversations.ConversationFactory
import org.bukkit.conversations.MessagePrompt
import org.bukkit.conversations.NumericPrompt
import org.bukkit.conversations.Prompt
import org.bukkit.conversations.StringPrompt
import org.bukkit.conversations.ValidatingPrompt
import org.bukkit.entity.Player

/**
 * Money subtract command.
 * Takes money from a player's active character.
 */
class MoneySubtractCommand(val plugin: RPKEconomyBukkit) : CommandExecutor {

    private val conversationFactory = ConversationFactory(plugin)
            .withModality(true)
            .withFirstPrompt(ProfileNamePrompt())
            .withEscapeSequence("cancel")
            .thatExcludesNonPlayersWithMessage(plugin.messages["not-from-console"])
            .addConversationAbandonedListener { event ->
                if (!event.gracefulExit()) {
                    val conversable = event.context.forWhom
                    if (conversable is Player) {
                        conversable.sendMessage(plugin.messages["operation-cancelled"])
                    }
                }
            }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(plugin.messages["not-from-console"])
            return true
        }
        if (!sender.hasPermission("rpkit.economy.command.money.subtract")) {
            sender.sendMessage(plugin.messages["no-permission-money-subtract"])
            return true
        }
        val minecraftProfileService = Services[RPKMinecraftProfileService::class.java]
        if (minecraftProfileService == null) {
            sender.sendMessage(plugin.messages["no-minecraft-profile-service"])
            return true
        }
        val characterService = Services[RPKCharacterService::class.java]
        if (characterService == null) {
            sender.sendMessage(plugin.messages["no-character-service"])
            return true
        }
        val economyService = Services[RPKEconomyService::class.java]
        if (economyService == null) {
            sender.sendMessage(plugin.messages["no-economy-service"])
            return true
        }
        val currencyService = Services[RPKCurrencyService::class.java]
        if (currencyService == null) {
            sender.sendMessage(plugin.messages["no-currency-service"])
            return true
        }
        if (args.isEmpty()) {
            conversationFactory.buildConversation(sender).begin()
            return true
        }
        val bukkitPlayer = plugin.server.getPlayer(args[0])
        if (bukkitPlayer == null) {
            sender.sendMessage(plugin.messages["money-subtract-profile-invalid-profile"])
            return true
        }
        val minecraftProfile = minecraftProfileService.getMinecraftProfile(bukkitPlayer)
        if (minecraftProfile == null) {
            sender.sendMessage(plugin.messages["no-profile"])
            return true
        }
        val profile = minecraftProfile.profile
        if (profile !is RPKProfile) {
            sender.sendMessage(plugin.messages["no-profile"])
            return true
        }
        if (args.size <= 1) {
            conversationFactory.buildConversation(sender).begin()
            return true
        }
        val character = characterService.getCharacters(profile)
                .firstOrNull { character -> character.name.startsWith(args[1]) }
        if (character == null) {
            sender.sendMessage(plugin.messages["money-subtract-character-invalid-character"])
            return true
        }
        if (args.size <= 2) {
            conversationFactory.buildConversation(sender).begin()
            return true
        }
        val currency = currencyService.getCurrency(RPKCurrencyName(args[2]))
        if (currency == null) {
            sender.sendMessage(plugin.messages["money-subtract-currency-invalid-currency"])
            return true
        }
        if (args.size <= 3) {
            conversationFactory.buildConversation(sender).begin()
            return true
        }
        try {
            val amount = args[3].toInt()
            if (amount < 0) {
                sender.sendMessage(plugin.messages["money-subtract-value-invalid-value-negative"])
                return true
            }
            economyService.setBalance(character, currency, economyService.getBalance(character, currency) - amount)
            sender.sendMessage(plugin.messages["money-subtract-amount-valid"])
            sender.sendMessage(plugin.messages["money-subtract-valid"])
        } catch (exception: NumberFormatException) {
            sender.sendMessage(plugin.messages["money-subtract-value-invalid-value-number"])
        }
        return true
    }

    private inner class ProfileNamePrompt : StringPrompt() {

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["money-subtract-profile-name-prompt"]
        }

        override fun acceptInput(context: ConversationContext, input: String?): Prompt {
            context.setSessionData("profileName", input)
            return ProfileDiscriminatorPrompt()
        }

    }

    private inner class ProfileDiscriminatorPrompt : NumericPrompt() {
        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["money-subtract-profile-discriminator-prompt"]
        }

        override fun acceptValidatedInput(context: ConversationContext, input: Number): Prompt {
            context.setSessionData("profileDiscriminator", input.toInt())
            val profileService = Services[RPKProfileService::class.java] ?: return ProfileInvalidPrompt()
            val profile = profileService.getProfile(
                    context.getSessionData("profileName") as String,
                    context.getSessionData("profileDiscriminator") as Int
            ) ?: return ProfileInvalidPrompt()
            context.setSessionData("profileService", profileService)
            context.setSessionData("profile", profile)
            return ProfileSetPrompt()
        }

    }

    private inner class ProfileSetPrompt : MessagePrompt() {
        override fun getNextPrompt(context: ConversationContext): Prompt {
            return CharacterPrompt()
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["money-subtract-profile-valid"]
        }

    }

    private inner class ProfileInvalidPrompt : MessagePrompt() {
        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["money-subtract-profile-invalid-profile"]
        }

        override fun getNextPrompt(context: ConversationContext): Prompt? {
            return ProfileNamePrompt()
        }

    }

    private inner class CharacterPrompt : ValidatingPrompt() {
        override fun isInputValid(context: ConversationContext, input: String): Boolean {
            val characterService = context.getSessionData("characterService") as RPKCharacterService
            return characterService
                    .getCharacters(context.getSessionData("profile") as RPKProfile)
                    .any { character -> character.name == input }
        }

        override fun acceptValidatedInput(context: ConversationContext, input: String): Prompt {
            val characterService = context.getSessionData("characterService") as RPKCharacterService
            context.setSessionData("character", characterService
                    .getCharacters(context.getSessionData("profile") as RPKProfile)
                    .first { character -> character.name == input }
            )
            return CharacterSetPrompt()
        }

        override fun getPromptText(context: ConversationContext): String {
            val characterService = context.getSessionData("characterService") as RPKCharacterService
            return plugin.messages["money-subtract-character-prompt"] +
                    "\n" +
                    characterService
                            .getCharacters(context.getSessionData("profile") as RPKProfile)
                            .joinToString("\n") { character ->
                                plugin.messages["money-subtract-character-prompt-list-item", mapOf(
                                    "character" to character.name
                                )]
                            }
        }

        override fun getFailedValidationText(context: ConversationContext, invalidInput: String): String {
            return plugin.messages["money-subtract-character-invalid-character"]
        }
    }

    private inner class CharacterSetPrompt : MessagePrompt() {
        override fun getNextPrompt(context: ConversationContext): Prompt {
            val currencyService = Services[RPKCurrencyService::class.java] ?: return END_OF_CONVERSATION
            context.setSessionData("currencyService", currencyService)
            return CurrencyPrompt()
        }

        override fun getPromptText(context: ConversationContext): String {
            if (Services[RPKCurrencyService::class.java] == null) return plugin.messages["no-currency-service"]
            return plugin.messages["money-subtract-character-valid"]
        }

    }

    private inner class CurrencyPrompt : ValidatingPrompt() {
        override fun isInputValid(context: ConversationContext, input: String): Boolean {
            val currencyService = context.getSessionData("currencyService") as RPKCurrencyService
            return currencyService.getCurrency(RPKCurrencyName(input)) != null
        }

        override fun acceptValidatedInput(context: ConversationContext, input: String): Prompt {
            val currencyService = context.getSessionData("currencyService") as RPKCurrencyService
            context.setSessionData("currency", currencyService.getCurrency(RPKCurrencyName(input)))
            return CurrencySetPrompt()
        }

        override fun getPromptText(context: ConversationContext): String {
            val currencyService = context.getSessionData("currencyService") as RPKCurrencyService
            return plugin.messages["money-subtract-currency-prompt"] + "\n" +
                    currencyService.currencies
                            .joinToString("\n") { currency ->
                                plugin.messages["money-subtract-currency-prompt-list-item", mapOf(
                                    "currency" to currency.name.value
                                )]
                            }
        }

        override fun getFailedValidationText(context: ConversationContext, invalidInput: String): String {
            return plugin.messages["money-subtract-currency-invalid-currency"]
        }
    }

    private inner class CurrencySetPrompt : MessagePrompt() {
        override fun getNextPrompt(context: ConversationContext): Prompt {
            return AmountPrompt()
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["money-subtract-currency-valid"]
        }

    }

    private inner class AmountPrompt : NumericPrompt() {

        override fun isNumberValid(context: ConversationContext, input: Number): Boolean {
            val economyService = Services[RPKEconomyService::class.java] ?: return false
            val balance = economyService.getBalance(context.getSessionData("character") as RPKCharacter, context.getSessionData("currency") as RPKCurrency)
            return input.toInt() in 1..balance
        }

        override fun acceptValidatedInput(context: ConversationContext, input: Number): Prompt {
            context.setSessionData("amount", input.toInt())
            return AmountSetPrompt()
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["money-subtract-amount-prompt"]
        }

        override fun getFailedValidationText(context: ConversationContext, invalidInput: Number): String {
            if (Services[RPKEconomyService::class.java] == null) {
                return plugin.messages["no-economy-service"]
            }
            return if (invalidInput.toInt() <= 0) {
                plugin.messages["money-subtract-amount-invalid-amount-negative"]
            } else {
                plugin.messages["money-subtract-amount-invalid-amount-balance"]
            }
        }

        override fun getInputNotNumericText(context: ConversationContext, invalidInput: String): String {
            return plugin.messages["money-subtract-amount-invalid-amount-number"]
        }

    }

    private inner class AmountSetPrompt : MessagePrompt() {
        override fun getNextPrompt(context: ConversationContext): Prompt {
            return MoneySubtractCompletePrompt()
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["money-subtract-amount-valid"]
        }

    }

    private inner class MoneySubtractCompletePrompt : MessagePrompt() {
        override fun getNextPrompt(context: ConversationContext): Prompt? {
            return END_OF_CONVERSATION
        }

        override fun getPromptText(context: ConversationContext): String {
            val economyService = Services[RPKEconomyService::class.java] ?: return plugin.messages["no-economy-service"]
            val character = context.getSessionData("character") as RPKCharacter
            val currency = context.getSessionData("currency") as RPKCurrency
            val amount = context.getSessionData("amount") as Int
            economyService.setBalance(character, currency, economyService.getBalance(character, currency) - amount)
            return plugin.messages["money-subtract-valid"]
        }

    }

}