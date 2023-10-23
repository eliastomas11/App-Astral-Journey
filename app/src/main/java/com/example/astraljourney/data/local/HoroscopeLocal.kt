package com.example.astraljourney.data.local

import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeLocal {

    suspend fun getHoroscopeInfo(sign: String): ZodiacSignResponse
}