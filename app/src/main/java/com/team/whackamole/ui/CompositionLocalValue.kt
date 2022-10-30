package com.team.whackamole.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel

class CompositionLocalValue {
    val LocalViewModel = compositionLocalOf<ViewModel?> { null}
}