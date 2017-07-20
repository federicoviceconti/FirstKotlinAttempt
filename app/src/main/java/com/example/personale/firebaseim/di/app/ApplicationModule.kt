package com.example.personale.firebaseim.di.app

import android.content.Context
import com.example.personale.firebaseim.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by personale on 7/19/17.
 */

@Module
class ApplicationModule(val app: App) {
    @Provides
    @Singleton
    fun getApplicationContext(): Context = app
}