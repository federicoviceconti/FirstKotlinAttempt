package com.example.personale.firebaseim.di.conversation

import com.example.personale.firebaseim.conversation.ConversationActivity
import dagger.Subcomponent
import javax.inject.Scope

/**
 * Created by personale on 7/19/17.
 */
@ConversationScope
@Subcomponent(modules = arrayOf(ConversationModule::class))
interface ConversationComponent{
    fun inject(target: ConversationActivity)
}

@Scope
annotation class ConversationScope
