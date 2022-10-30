package com.team.whackamole.ui.koin

import com.team.whackamole.ui.viewmodels.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {

    viewModel<GameViewModel> {
        GameViewModel()
    }
}