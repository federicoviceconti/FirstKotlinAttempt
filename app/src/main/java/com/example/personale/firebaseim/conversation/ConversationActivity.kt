package com.example.personale.firebaseim.conversation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.personale.firebaseim.App
import com.example.personale.firebaseim.R
import com.example.personale.firebaseim.conversation.adapter.ConversationAdapter
import com.example.personale.firebaseim.conversation.adapter.ConversationDelegateAdapter
import com.example.personale.firebaseim.conversation.presenter.ConversationPresenterImpl
import com.example.personale.firebaseim.model.Conversation
import kotlinx.android.synthetic.main.activity_conversation.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by personale on 7/19/17.
 */

class ConversationActivity : AppCompatActivity(), ConversationView {
    @Inject lateinit var convPresenter: ConversationPresenterImpl

    val adapterConversation: ConversationDelegateAdapter by lazy { ConversationAdapter() }
    val adapterPresenter: ConversationDelegateAdapter.DelegatePresenter by lazy { adapterConversation.DelegatePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        (application as App).conversationComponent.inject(this)
        initialize()
    }

    override fun onStart() {
        super.onStart()
        convPresenter.view = this
    }

    private fun initialize() {
        val recycler = find<RecyclerView>(conversation_recycler.id).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ConversationActivity)
            adapter = adapterConversation
        }

        convPresenter.loadConversation()
    }

    override fun showConversationMessage(s: String) {
        toast(s)
    }

    override fun addConversation(value: Conversation?) {
        super.addConversation(value)
        value?.let { adapterPresenter.add(value) }
    }
}
