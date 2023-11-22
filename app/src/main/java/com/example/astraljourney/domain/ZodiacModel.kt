package com.example.astraljourney.domain

import com.example.astraljourney.R

enum class ZodiacModel(val image: Int,val anim: Int) {
    Aries(R.drawable.aries,R.raw.aries_anim),
    Taurus(R.drawable.tauro,R.raw.tauro_anim),
    Gemini(R.drawable.geminis,R.raw.gemini_anim),
    Cancer(R.drawable.cancer,R.raw.cancer_anim),
    Leo(R.drawable.leo,R.raw.leo_anim),
    Virgo(R.drawable.virgo,R.raw.virgo_anim),
    Libra(R.drawable.libra,R.raw.libra_anim),
    Scorpio(R.drawable.escorpio,R.raw.scorpio_anim),
    Sagittarius(R.drawable.sagitario,R.raw.sagittarius_anim),
    Capricorn(R.drawable.capricornio,R.raw.capricorn_anim),
    Aquarius(R.drawable.acuario,R.raw.acuario_anim),
    Pisces(R.drawable.piscis,R.raw.piscis_anim);
}