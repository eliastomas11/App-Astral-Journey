package com.example.astraljourney.data.repositories

import com.example.astraljourney.core.toDomain
import com.example.astraljourney.data.local.HoroscopeLocal
import com.example.astraljourney.data.remote.HoroscopeRemote
import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse
import com.example.astraljourney.domain.HoroscopeRepository
import com.example.astraljourney.domain.ZodiacSign
import com.example.astraljourney.domain.ZodiacSignInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val horoscopeRemote: HoroscopeRemote,
    private val horoscopeLocal: HoroscopeLocal,
) : HoroscopeRepository {
    override suspend fun getZodiacSign(sign: String): ZodiacSign {
        return withContext(dispatcher) {
            horoscopeRemote.getZodiacSign(sign).toDomain()
        }
    }

    override fun getZodiacList(): List<ZodiacSignInfo> {
        return listOf(
            ZodiacSignInfo.Aries,
            ZodiacSignInfo.Taurus,
            ZodiacSignInfo.Gemini,
            ZodiacSignInfo.Cancer,
            ZodiacSignInfo.Leo,
            ZodiacSignInfo.Virgo,
            ZodiacSignInfo.Libra,
            ZodiacSignInfo.Scorpio,
            ZodiacSignInfo.Sagittarius,
            ZodiacSignInfo.Capricorn,
            ZodiacSignInfo.Aquarius,
            ZodiacSignInfo.Pisces
        )
    }
}
