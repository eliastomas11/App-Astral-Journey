package com.example.astraljourney.data.remote.remotemodel

import com.google.gson.annotations.SerializedName

data class ZodiacSignResponse(
    @SerializedName("date")val date: String,
    @SerializedName("horoscope")val horoscope: String,
    @SerializedName("sign")val sign: String
)