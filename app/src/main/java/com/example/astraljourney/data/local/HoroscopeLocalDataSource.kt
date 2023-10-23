package com.example.astraljourney.data.local

import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse
import javax.inject.Inject

class HoroscopeLocalDataSource @Inject constructor() : HoroscopeLocal {
    override suspend fun getHoroscopeInfo(sign: String): ZodiacSignResponse {
        return ZodiacSignResponse("","","")
    }
}