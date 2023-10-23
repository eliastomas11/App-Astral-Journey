package com.example.astraljourney.domain

import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse

interface HoroscopeRepository{
    suspend fun getZodiacSign(sign:String): ZodiacSign
    fun getZodiacList(): List<ZodiacSignInfo>
}
