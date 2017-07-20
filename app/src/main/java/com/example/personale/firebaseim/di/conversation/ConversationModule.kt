package com.example.personale.firebaseim.di.conversation

import com.example.personale.firebaseim.conversation.presenter.ConversationPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by personale on 7/19/17.
 */

@Module
class ConversationModule {
    @Provides
    @ConversationScope
    fun providesConversationPresenter() = ConversationPresenterImpl()
}