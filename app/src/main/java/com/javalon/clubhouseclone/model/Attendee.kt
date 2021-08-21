package com.javalon.clubhouseclone.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Attendee(
    @DrawableRes val attendeeImage: Int,
    @ColorRes val attendeeBg: Int,
    val attendeeName: String,
    val isSpeaking: Boolean = false
)