package com.example.astraljourney.domain

import com.example.astraljourney.R

    sealed class ZodiacSignInfo(val name:Int, val image:Int, val id: ZodiacModel){

    object Aries: ZodiacSignInfo(R.string.aries_zodiac_name, R.drawable.aries, ZodiacModel.Aries)
    object Taurus: ZodiacSignInfo(R.string.taurus_zodiac_name, R.drawable.taurus, ZodiacModel.Tauro)
    object Gemini: ZodiacSignInfo(R.string.gemini_zodiac_name, R.drawable.gemini, ZodiacModel.Gemini)
    object Cancer: ZodiacSignInfo(R.string.cancer_zodiac_name, R.drawable.cancer, ZodiacModel.Cancer)
    object Leo: ZodiacSignInfo(R.string.leo_zodiac_name, R.drawable.leo, ZodiacModel.Leo)
    object Virgo: ZodiacSignInfo(R.string.virgo_zodiac_name, R.drawable.virgo, ZodiacModel.Virgo)
    object Libra: ZodiacSignInfo(R.string.libra_zodiac_name, R.drawable.libra, ZodiacModel.Libra)
    object Scorpio: ZodiacSignInfo(R.string.scorpio_zodiac_name, R.drawable.scorpio, ZodiacModel.Escorpio)
    object Sagittarius: ZodiacSignInfo(R.string.sagittarius_zodiac_name, R.drawable.sagittarius, ZodiacModel.Sagitario)
    object Capricorn: ZodiacSignInfo(R.string.capricorn_zodiac_name, R.drawable.capricorn, ZodiacModel.Capricornio)
    object Aquarius: ZodiacSignInfo(R.string.aquarius_zodiac_name, R.drawable.aquarius, ZodiacModel.Acuario)
    object Pisces: ZodiacSignInfo(R.string.pisces_zodiac_name, R.drawable.pisces, ZodiacModel.Piscis)
}
