package com.netwerk.salttest

import android.app.Application
import com.netwerk.salttest.di.dispatcherModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module


class SaltApplication : Application() {

    private val moduleList: List<Module> = listOf(
        dispatcherModule,
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SaltApplication)
            modules(moduleList)
        }
    }
}