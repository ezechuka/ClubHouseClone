package com.javalon.clubhouseclone.model

import androidx.annotation.DrawableRes

data class ChipModel(val title: String, @DrawableRes val icon: Int, val isSelected: Boolean = false)