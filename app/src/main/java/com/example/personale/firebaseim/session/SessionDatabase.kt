package com.example.personale.firebaseim.session

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by personale on 7/19/17.
 */

interface ReadFromDB{
    fun detachListener(childEventListener: ChildEventListener)
    fun attachListener(childEventListener: ChildEventListener)
}
interface WriteOnDB{
    fun writeUserOnDb()
    fun writeMessageOnDb()
}

sealed class SessionDatabase{
    protected val dbReference: DatabaseReference = FirebaseDatabase
            .getInstance()
            .reference
            .root

    class DatabaseRead: SessionDatabase(), ReadFromDB{
        override fun detachListener(childEventListener: ChildEventListener) {
            dbReference.removeEventListener(childEventListener)
        }

        override fun attachListener(childEventListener: ChildEventListener) {
            dbReference.addChildEventListener(childEventListener)
        }
    }

    class DatabaseWrite: SessionDatabase(), WriteOnDB{
        override fun writeUserOnDb() {
        }

        override fun writeMessageOnDb() {
        }
    }
}