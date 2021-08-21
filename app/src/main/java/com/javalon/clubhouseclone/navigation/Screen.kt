package com.javalon.clubhouseclone.navigation

import androidx.annotation.StringRes
import com.javalon.clubhouseclone.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object HomeScreen : Screen("home", R.string.home)
    object RoomScreen : Screen("room", R.string.room)
}