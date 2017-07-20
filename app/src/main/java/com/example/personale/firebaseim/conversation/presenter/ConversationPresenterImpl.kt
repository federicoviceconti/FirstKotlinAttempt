package com.example.personale.firebaseim.conversation.presenter

import com.example.personale.firebaseim.conversation.ConversationActivity
import com.example.personale.firebaseim.model.Conversation
import com.example.personale.firebaseim.session.SessionDatabase
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

/**
 * Created by personale on 7/19/17.
 */
class ConversationPresenterImpl : ConversationPresenter {
    lateinit var view: ConversationActivity

    val listener: ChildEventListener = object : ChildEventListener {
        override fun onCancelled(p0: DatabaseError?) {}
        override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
        override fun onChildChanged(p0: DataSnapshot?, p1: String?) {}
        override fun onChildAdded(p0: DataSnapshot?, p1: String?) { view.addConversation(p0?.getValue(Conversation::class.java)) }
        override fun onChildRemoved(p0: DataSnapshot?) {}
    }

    override fun loadConversation() {
        SessionDatabase.DatabaseRead().attachListener(listener)
    }

    override fun exitFromApp() {
        SessionDatabase.DatabaseRead().detachListener(listener)
        view.finish()
    }

    override fun onConversationClicked() {
    }

    override fun onConversationSelected() {
    }
}