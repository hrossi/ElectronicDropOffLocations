package io.github.hrossi.di

import io.github.hrossi.data.remote.NYDataRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory {
        NYDataRepository(get())
    }
}