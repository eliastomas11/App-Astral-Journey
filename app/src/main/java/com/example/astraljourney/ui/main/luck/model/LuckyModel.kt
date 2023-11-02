package com.example.astraljourney.ui.main.luck.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel(
    @DrawableRes val image: Int,
    @StringRes val prediction: Int,
)
