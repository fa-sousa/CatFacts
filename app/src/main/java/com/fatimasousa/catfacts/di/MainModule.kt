package com.fatimasousa.catfacts.di

import com.fatimasousa.catfacts.repository.FactActivityRepository
import com.fatimasousa.catfacts.viewmodel.FactActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    viewModel {
        FactActivityViewModel(
                FactActivityRepository
        )
    }

}