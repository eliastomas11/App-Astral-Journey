package com.example.astraljourney.data.remote

import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getZodiacSignInfo(@Path("sign") sign: String): ZodiacSignResponse
}