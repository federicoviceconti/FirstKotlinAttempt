package com.example.personale.firebaseim.login.presenter

import com.example.personale.firebaseim.common.CommonField
import com.example.personale.firebaseim.login.LoginView
import com.example.personale.firebaseim.session.SessionAuthentication

/**
 * Created by personale on 7/18/17.
 */

class LoginPresenterImpl : LoginPresenter {
    lateinit var view: LoginView

    override fun onRegisterClicked(username: String, password: String) {
        SessionAuthentication.Register().execute(username, password)
                ?.addOnCompleteListener {
                    operation(CommonField.SUCCESS_REGISTER, CommonField.ERROR_REGISTER, if(it.isSuccessful) it.result.user.uid else "")
                }?.addOnFailureListener { view.showLoginMessage(it.message ?: "") }
    }

    override fun onLoginClicked(username: String, password: String) {
        SessionAuthentication.SignIn().execute(username, password)
                ?.addOnCompleteListener {
                    if(it.isSuccessful) operation(CommonField.SUCCESS_LOGIN, CommonField.ERROR_LOGIN, it.result?.user?.uid ?: "")
                }?.addOnFailureListener { view.showLoginMessage(it.message ?: "") }
    }

    private fun operation(success: String, failed: String, toConversation: String) {
        if(toConversation.isNotBlank()) {
            view.showLoginMessage(success)
            view.changeActivityToConversation(toConversation)
        } else {
            view.showLoginMessage(failed)
        }
    }
}