package com.example.personale.firebaseim.conversation

import com.example.personale.firebaseim.common.BaseView
import com.example.personale.firebaseim.model.Conversation

/**
 * Created by personale on 7/19/17.
 */

interface ConversationView: BaseView {
    fun showConversationMessage(s: String)
    fun addConversation(value: Conversation?) {}
}