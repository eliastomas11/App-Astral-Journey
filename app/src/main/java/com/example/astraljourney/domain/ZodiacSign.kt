package com.example.astraljourney.domain

import com.example.astraljourney.R

sealed class ZodiacSign(val name:Int,val image:Int){

    object Aries: ZodiacSign(R.string.aries_zodiac_name, R.drawable.aries)
    object Taurus: ZodiacSign(R.string.taurus_zodiac_name, R.drawable.taurus)
    object Gemini: ZodiacSign(R.string.gemini_zodiac_name, R.drawable.gemini)
    object Cancer: ZodiacSign(R.string.cancer_zodiac_name, R.drawable.cancer)
    object Leo: ZodiacSign(R.string.leo_zodiac_name, R.drawable.leo)
    object Virgo: ZodiacSign(R.string.virgo_zodiac_name, R.drawable.virgo)
    object Libra: ZodiacSign(R.string.libra_zodiac_name, R.drawable.libra)
    object Scorpio: ZodiacSign(R.string.scorpio_zodiac_name, R.drawable.scorpio)
    object Sagittarius: ZodiacSign(R.string.sagittarius_zodiac_name, R.drawable.sagittarius)
    object Capricorn: ZodiacSign(R.string.capricorn_zodiac_name, R.drawable.capricorn)
    object Aquarius: ZodiacSign(R.string.aquarius_zodiac_name, R.drawable.aquarius)
    object Pisces: ZodiacSign(R.string.pisces_zodiac_name, R.drawable.pisces)
}
