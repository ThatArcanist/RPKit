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

package com.rpkit.players.bukkit.profile.github

import com.rpkit.core.service.Service
import com.rpkit.players.bukkit.profile.RPKProfile


interface RPKGitHubProfileService : Service {

    fun getGitHubProfile(id: RPKGitHubProfileId): RPKGitHubProfile?
    fun getGitHubProfile(name: RPKGitHubUsername): RPKGitHubProfile?
    fun getGitHubProfiles(profile: RPKProfile): List<RPKGitHubProfile>
    fun addGitHubProfile(profile: RPKGitHubProfile)
    fun createGitHubProfile(
        profile: RPKProfile,
        name: RPKGitHubUsername,
        oauthToken: String
    ): RPKGitHubProfile
    fun updateGitHubProfile(profile: RPKGitHubProfile)
    fun removeGitHubProfile(profile: RPKGitHubProfile)

}