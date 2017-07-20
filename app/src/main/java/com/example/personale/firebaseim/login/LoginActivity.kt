package com.example.personale.firebaseim.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.personale.firebaseim.App
import com.example.personale.firebaseim.R
import com.example.personale.firebaseim.common.CommonField
import com.example.personale.firebaseim.conversation.ConversationActivity
import com.example.personale.firebaseim.login.presenter.LoginPresenterImpl
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by personale on 7/18/17.
 */

class LoginActivity : AppCompatActivity(), LoginView, View.OnClickListener {

    @Inject
    lateinit var loginPresenter: LoginPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as App).loginComponent.inject(this)

        find<Button>(R.id.login_register_btn).setOnClickListener(this)
        find<Button>(R.id.login_login_btn).setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        loginPresenter.view = this
    }

    override fun changeActivityToConversation(uid: String) {
        val toConversation = Intent(this, ConversationActivity::class.java)
        toConversation.putExtra(CommonField.UID, uid)
        startActivity(toConversation)
    }

    override fun showLoginMessage(s: String) { toast(s) }

    override fun onClick(p0: View?) =
            when (p0?.id) {
                R.id.login_login_btn -> loginPresenter.onLoginClicked(login_username.text.toString(), login_password.text.toString())
                R.id.login_register_btn -> loginPresenter.onRegisterClicked(login_username.text.toString(), login_password.text.toString())
                else -> { toast("An error is occurred!") }
            }
}