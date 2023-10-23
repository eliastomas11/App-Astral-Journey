package com.example.astraljourney.domain.usecases

import com.example.astraljourney.domain.ZodiacSign
import com.example.astraljourney.domain.ZodiacSignInfo

sealed interface HoroscopeUseCases {
    fun interface GetZodiacList : () -> List<ZodiacSignInfo>
    fun interface GetZodiacSignInfo : suspend (String) -> ZodiacSign

}

