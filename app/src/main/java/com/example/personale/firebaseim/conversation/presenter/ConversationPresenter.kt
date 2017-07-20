package com.example.personale.firebaseim.conversation.presenter

import com.example.personale.firebaseim.common.BasePresenter

/**
 * Created by personale on 7/19/17.
 */

interface ConversationPresenter: BasePresenter{
    fun loadConversation()
    fun exitFromApp()
    fun onConversationClicked()
    fun onConversationSelected()
}