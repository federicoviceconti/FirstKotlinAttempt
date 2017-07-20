package com.example.personale.firebaseim

import android.app.Application
import com.example.personale.firebaseim.di.app.ApplicationComponent
import com.example.personale.firebaseim.di.app.ApplicationModule
import com.example.personale.firebaseim.di.app.DaggerApplicationComponent
import com.example.personale.firebaseim.di.conversation.ConversationComponent
import com.example.personale.firebaseim.di.conversation.ConversationModule
import com.example.personale.firebaseim.di.login.LoginComponent
import com.example.personale.firebaseim.di.login.LoginModule

/**
 * Created by personale on 7/18/17.
 */

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    val loginComponent: LoginComponent by lazy {
        appComponent.addLoginComponent(LoginModule())
    }

    val conversationComponent: ConversationComponent by lazy {
        appComponent.addConversationComponent(ConversationModule())
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}