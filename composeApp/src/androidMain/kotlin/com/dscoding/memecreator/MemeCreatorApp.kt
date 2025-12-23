package com.dscoding.memecreator

import android.app.Application
import com.dscoding.memecreator.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MemeCreatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
             androidContext(this@MemeCreatorApp)
        }
    }
}