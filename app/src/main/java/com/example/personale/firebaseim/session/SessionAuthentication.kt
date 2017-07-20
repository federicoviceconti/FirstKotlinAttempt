package com.example.personale.firebaseim.session

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import rx.Observable
import rx.Scheduler
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by personale on 7/19/17.
 */

sealed class SessionAuthentication {
    protected val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    abstract fun execute(email: String, password: String): Task<AuthResult>?
    open fun execute(): Boolean {return false}

    class SignIn : SessionAuthentication() {
        override fun execute(email: String, password: String): Task<AuthResult>? =
        if(email.isNotBlank() && password.isNotBlank())
                firebaseAuth.signInWithEmailAndPassword(email.addEndMail(), password)
        else null
    }

    class SignOut() : SessionAuthentication() {
        override fun execute(email: String, password: String): Task<AuthResult>? = null

        override fun execute(): Boolean {
            firebaseAuth.signOut()
            return true
        }
    }

    class Register : SessionAuthentication() {
        override fun execute(email: String, password: String): Task<AuthResult>? =
            if(password.verifyPassword()){
                firebaseAuth.createUserWithEmailAndPassword(email.addEndMail(), password) }
            else { null }
    }
}

private fun String.addEndMail() = if(!contains("@gmail.com")) this + "@gmail.com" else this
private fun String.verifyPassword(): Boolean = length >= 6