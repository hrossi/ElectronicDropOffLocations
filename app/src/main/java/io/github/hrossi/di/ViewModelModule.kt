package io.github.hrossi.di

import io.github.hrossi.presentation.dropofflocation.list.DropOffLocationListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        DropOffLocationListViewModel(get())
    }
}