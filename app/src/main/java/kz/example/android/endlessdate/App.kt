package kz.example.android.endlessdate

import android.app.Application
import kz.example.android.endlessdate.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
            androidContext(this@App)
        }
    }
}