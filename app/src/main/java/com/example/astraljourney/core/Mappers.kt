package com.example.astraljourney.core

import com.example.astraljourney.data.remote.remotemodel.ZodiacSignResponse
import com.example.astraljourney.domain.ZodiacModel
import com.example.astraljourney.domain.ZodiacSign

fun ZodiacSignResponse.toDomain(): ZodiacSign = ZodiacSign(zodiacModel = this.toZodiacModel(), date = this.date, description = this.horoscope)

fun ZodiacSignResponse.toZodiacModel() : ZodiacModel = when (this.sign) {
    "Aries" -> ZodiacModel.Aries
    "Taurus" -> ZodiacModel.Tauro
    "Gemini" -> ZodiacModel.Gemini
    "Cancer" -> ZodiacModel.Cancer
    "Leo" -> ZodiacModel.Leo
    "Virgo" -> ZodiacModel.Virgo
    "Libra" -> ZodiacModel.Libra
    "Scorpio" -> ZodiacModel.Escorpio
    "Sagittarius" -> ZodiacModel.Sagitario
    "Capricorn" -> ZodiacModel.Capricornio
    "Aquarius" -> ZodiacModel.Acuario
    else -> {ZodiacModel.Piscis}
}