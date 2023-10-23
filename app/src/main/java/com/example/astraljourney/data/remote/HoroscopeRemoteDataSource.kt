package com.example.astraljourney.data.remote

import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse
import javax.inject.Inject

class HoroscopeRemoteDataSource @Inject constructor(private val horoscopeService: HoroscopeApiService) : HoroscopeRemote{
    override suspend fun getZodiacSign(sign: String): ZodiacSignResponse {
        return horoscopeService.getZodiacSignInfo(sign)
    }
}