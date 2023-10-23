package com.example.astraljourney.domain

import com.example.astraljourney.R

enum class ZodiacModel(val image: Int,val anim: Int) {
    Aries(R.drawable.aries,R.raw.aries_anim),
    Tauro(R.drawable.capricornio,R.raw.tauro_anim),
    Gemini(R.drawable.geminis,R.raw.gemini_anim),
    Cancer(R.drawable.cancer,R.raw.cancer_anim),
    Leo(R.drawable.leo,R.raw.leo_anim),
    Virgo(R.drawable.virgo,R.raw.virgo_anim),
    Libra(R.drawable.libra,R.raw.libra_anim),
    Escorpio(R.drawable.escorpio,R.raw.scorpio_anim),
    Sagitario(R.drawable.sagitario,R.raw.sagittarius_anim),
    Capricornio(R.drawable.capricornio,R.raw.capricorn_anim),
    Acuario(R.drawable.acuario,R.raw.acuario_anim),
    Piscis(R.drawable.piscis,R.raw.piscis_anim);
}