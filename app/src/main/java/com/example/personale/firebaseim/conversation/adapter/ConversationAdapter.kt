package com.example.personale.firebaseim.conversation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.personale.firebaseim.R
import com.example.personale.firebaseim.common.CommonField
import com.example.personale.firebaseim.common.inflate
import com.example.personale.firebaseim.model.Message
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_conversation.view.*

/**
 * Created by personale on 7/18/17.
 */

class ConversationAdapter: ConversationDelegateAdapter() {
    override fun onBindViewHolder(holder: MessageVH?, position: Int) {
        holder?.bind(list[position].getLastMessage())
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            MessageVH(parent?.let { parent.inflate(R.layout.item_conversation) } as View)

    inner class MessageVH(item: View): RecyclerView.ViewHolder(item){
        fun bind(mex: Message){
            with(itemView){
                conversation_user.text = mex.receiver.username
                conversation_text.text = mex.text
                conversation_img.load(mex.receiver.pic)
                conversation_date.text = mex.time
            }
        }
    }
}

private fun ImageView.load(pic: String)
        = Picasso
            .with(this.context)
            .load(if(pic.isNotBlank()) pic else CommonField.PLACEHOLDER)
            .into(this)