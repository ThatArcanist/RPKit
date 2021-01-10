package com.rpkit.characters.bukkit.web.character

import org.http4k.core.Body
import org.http4k.format.Gson.auto

data class CharacterPostRequest(
    val name: String,
    val gender: String?,
    val age: Int,
    val raceId: Int?,
    val description: String,
    val isDead: Boolean,
    val isProfileHidden: Boolean,
    val isNameHidden: Boolean,
    val isGenderHidden: Boolean,
    val isAgeHidden: Boolean,
    val isRaceHidden: Boolean,
    val isDescriptionHidden: Boolean
) {
    companion object {
        val lens = Body.auto<CharacterPostRequest>().toLens()
    }
}