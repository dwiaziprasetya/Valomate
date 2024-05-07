package com.example.valomate.data.remote.response

import com.google.gson.annotations.SerializedName

data class AgentsResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("status")
	val status: Int
)

data class RecruitmentData(

	@field:SerializedName("levelVpCostOverride")
	val levelVpCostOverride: Int,

	@field:SerializedName("endDate")
	val endDate: String,

	@field:SerializedName("milestoneThreshold")
	val milestoneThreshold: Int,

	@field:SerializedName("milestoneId")
	val milestoneId: String,

	@field:SerializedName("useLevelVpCostOverride")
	val useLevelVpCostOverride: Boolean,

	@field:SerializedName("counterId")
	val counterId: String,

	@field:SerializedName("startDate")
	val startDate: String
)

data class Role(

	@field:SerializedName("displayIcon")
	val displayIcon: String,

	@field:SerializedName("displayName")
	val displayName: String,

	@field:SerializedName("assetPath")
	val assetPath: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("uuid")
	val uuid: String
)

data class AbilitiesItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String,

	@field:SerializedName("displayName")
	val displayName: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("slot")
	val slot: String
)

data class DataItem(

	@field:SerializedName("killfeedPortrait")
	val killfeedPortrait: String,

	@field:SerializedName("role")
	val role: Role,

	@field:SerializedName("isFullPortraitRightFacing")
	val isFullPortraitRightFacing: Boolean,

	@field:SerializedName("displayName")
	val displayName: String,

	@field:SerializedName("isBaseContent")
	val isBaseContent: Boolean,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("backgroundGradientColors")
	val backgroundGradientColors: List<String>,

	@field:SerializedName("isAvailableForTest")
	val isAvailableForTest: Boolean,

	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("characterTags")
	val characterTags: Any,

	@field:SerializedName("displayIconSmall")
	val displayIconSmall: String,

	@field:SerializedName("fullPortrait")
	val fullPortrait: String,

	@field:SerializedName("fullPortraitV2")
	val fullPortraitV2: String,

	@field:SerializedName("abilities")
	val abilities: List<AbilitiesItem>,

	@field:SerializedName("displayIcon")
	val displayIcon: String,

	@field:SerializedName("recruitmentData")
	val recruitmentData: Any,

	@field:SerializedName("bustPortrait")
	val bustPortrait: String,

	@field:SerializedName("background")
	val background: String,

	@field:SerializedName("assetPath")
	val assetPath: String,

	@field:SerializedName("voiceLine")
	val voiceLine: Any,

	@field:SerializedName("isPlayableCharacter")
	val isPlayableCharacter: Boolean,

	@field:SerializedName("developerName")
	val developerName: String
)
