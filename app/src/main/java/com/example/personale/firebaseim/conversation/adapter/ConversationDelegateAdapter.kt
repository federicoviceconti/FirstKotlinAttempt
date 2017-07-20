package com.example.personale.firebaseim.conversation.adapter

import android.support.v7.widget.RecyclerView
import com.example.personale.firebaseim.model.Conversation

/**
 * Created by personale on 7/19/17.
 */

abstract class ConversationDelegateAdapter: RecyclerView.Adapter<ConversationAdapter.MessageVH>(){
    protected var list: MutableList<Conversation> = mutableListOf()

    inner class DelegateView: ConversationAdapterMVP.View{
        val presenterDelegate: DelegatePresenter by lazy { DelegatePresenter() }

        override fun refresh() {
            notifyDataSetChanged()
        }

        override fun refreshSingleItemAdded(p: Int) {
            notifyItemInserted(p)
        }

        override fun refreshItemDeleted(p: Int){
            notifyItemRemoved(p)
        }

        override fun clickOnItem() { presenterDelegate.onConversationClicked() }
    }

    inner class DelegatePresenter: ConversationAdapterMVP.Presenter{
        val viewDelegate: DelegateView by lazy { DelegateView() }

        override fun add(conversation: Conversation) {
            list.add(0, conversation)
            viewDelegate.refreshSingleItemAdded(0)
        }
        override fun remove(pos: Int) {list - list[pos]}
        override fun set(newList: MutableList<Conversation>) {list = newList}
        override fun onConversationClicked() {}
    }
}