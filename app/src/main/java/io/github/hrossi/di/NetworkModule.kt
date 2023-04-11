package io.github.hrossi.di

import io.github.hrossi.data.remote.NYDataService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://data.cityofnewyork.us/"

val networkModule = module {

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    single {
        get<Retrofit>()
            .create(NYDataService::class.java)
    }
}