package com.example.astraljourney.data.remote

import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse

interface HoroscopeRemote {
    suspend fun getZodiacSign(sign: String): ZodiacSignResponse
}