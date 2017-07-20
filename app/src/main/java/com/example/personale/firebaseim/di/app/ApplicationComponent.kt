package com.example.personale.firebaseim.di.app

import com.example.personale.firebaseim.di.conversation.ConversationComponent
import com.example.personale.firebaseim.di.conversation.ConversationModule
import com.example.personale.firebaseim.di.login.LoginComponent
import com.example.personale.firebaseim.di.login.LoginModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by personale on 7/19/17.
 */

@Singleton
@Component(modules= arrayOf(ApplicationModule::class))
interface ApplicationComponent{
    fun addConversationComponent(conversationModule: ConversationModule): ConversationComponent
    fun addLoginComponent(loginModule: LoginModule): LoginComponent
}