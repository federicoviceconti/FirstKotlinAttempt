package com.example.personale.firebaseim.conversation.adapter

import com.example.personale.firebaseim.model.Conversation
import com.example.personale.firebaseim.model.Message

/**
 * Created by personale on 7/18/17.
 */

interface ConversationAdapterMVP{
    interface View {
        fun refresh()
        fun refreshSingleItemAdded(p: Int)
        fun refreshItemDeleted(p: Int)
        fun clickOnItem()
    }

    interface Presenter{
        fun add(conversation: Conversation)
        fun remove(pos: Int)
        fun set(newList: MutableList<Conversation>)
        fun onConversationClicked()
    }
}