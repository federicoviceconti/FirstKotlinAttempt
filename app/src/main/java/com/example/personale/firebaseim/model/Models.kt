package com.example.personale.firebaseim.model

/**
 * Created by personale on 7/18/17.
 */

data class User(var username: String = "", var password: String = "", var pic: String = "")

data class Conversation(var uid: String = "", var messageList: MutableList<Message> = mutableListOf()) {
    fun getLastMessage(): Message = messageList[messageList.size - 1]
}

data class Message(var text: String = "", var time: String = "", var receiver: User = User("", ""), var visualized: Boolean = false)
