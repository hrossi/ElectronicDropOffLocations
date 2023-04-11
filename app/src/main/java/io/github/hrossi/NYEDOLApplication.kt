package io.github.hrossi

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.NightMode
import io.github.hrossi.di.networkModule
import io.github.hrossi.di.repositoryModule
import io.github.hrossi.di.viewModelModule
import org.koin.core.context.startKoin

class NYEDOLApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }

        if (BuildConfig.DEBUG) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}