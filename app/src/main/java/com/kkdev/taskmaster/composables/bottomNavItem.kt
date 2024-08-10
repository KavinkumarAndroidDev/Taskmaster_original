package com.kkdev.taskmaster.composables

import androidx.compose.ui.graphics.vector.ImageVector

data class bottomNavItem(
    val title:String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route: String
)
