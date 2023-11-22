package com.example.astraljourney.domain

import com.example.astraljourney.R

    sealed class ZodiacSignInfo(val name:Int,val zodiacModel: ZodiacModel){

    object Aries: ZodiacSignInfo(R.string.aries_zodiac_name, ZodiacModel.Aries)
    object Taurus: ZodiacSignInfo(R.string.taurus_zodiac_name,ZodiacModel.Taurus)
    object Gemini: ZodiacSignInfo(R.string.gemini_zodiac_name, ZodiacModel.Gemini)
    object Cancer: ZodiacSignInfo(R.string.cancer_zodiac_name, ZodiacModel.Cancer)
    object Leo: ZodiacSignInfo(R.string.leo_zodiac_name,ZodiacModel.Leo)
    object Virgo: ZodiacSignInfo(R.string.virgo_zodiac_name, ZodiacModel.Virgo)
    object Libra: ZodiacSignInfo(R.string.libra_zodiac_name, ZodiacModel.Libra)
    object Scorpio: ZodiacSignInfo(R.string.scorpio_zodiac_name, ZodiacModel.Scorpio)
    object Sagittarius: ZodiacSignInfo(R.string.sagittarius_zodiac_name, ZodiacModel.Sagittarius)
    object Capricorn: ZodiacSignInfo(R.string.capricorn_zodiac_name, ZodiacModel.Capricorn)
    object Aquarius: ZodiacSignInfo(R.string.aquarius_zodiac_name, ZodiacModel.Aquarius)
    object Pisces: ZodiacSignInfo(R.string.pisces_zodiac_name, ZodiacModel.Pisces)
}
