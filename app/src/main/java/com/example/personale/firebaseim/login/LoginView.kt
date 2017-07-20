package com.example.personale.firebaseim.login

import android.view.View
import com.example.personale.firebaseim.common.BaseView

/**
 * Created by personale on 7/18/17.
 */

interface LoginView: BaseView{
    fun changeActivityToConversation(uid: String)
    fun showLoginMessage(s: String)
}