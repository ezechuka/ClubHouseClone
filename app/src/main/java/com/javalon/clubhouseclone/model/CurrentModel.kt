package com.javalon.clubhouseclone.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CurrentModel(
    val title: String,
    val desc: String,
    val attendees: Int,
    val speakers: Int,
    @DrawableRes val invitees: List<Int>
)