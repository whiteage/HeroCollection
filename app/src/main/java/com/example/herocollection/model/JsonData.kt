package com.example.herocollection.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class HeroDto(
    val response: String,
    val id: String,
    val name: String,
    val powerstats: PowerStatsDto,
    val biography: BiographyDto,
    val appearance: AppearanceDto,
    val work: WorkDto,
    val connections: ConnectionsDto,
    val image: ImageDto
)

data class PowerStatsDto(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class BiographyDto(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("alter-egos") val alterEgos: String,
    val aliases: List<String>,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("first-appearance") val firstAppearance: String,
    val publisher: String,
    val alignment: String
)
@Serializable
data class AppearanceDto(
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    @SerializedName("eye-color") val eyeColor: String,
    @SerializedName("hair-color") val hairColor: String
)

data class WorkDto(
    val occupation: String,
    val base: String
)

data class ConnectionsDto(
    @SerializedName("group-affiliation") val groupAffiliation: String,
    val relatives: String
)

data class ImageDto(
    val url: String
)
