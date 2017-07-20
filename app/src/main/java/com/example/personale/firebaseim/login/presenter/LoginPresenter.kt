package com.example.personale.firebaseim.login.presenter

import com.example.personale.firebaseim.common.BasePresenter

/**
 * Created by personale on 7/18/17.
 */

interface LoginPresenter: BasePresenter{
    fun onLoginClicked(username: String, password: String)
    fun onRegisterClicked(username: String, password: String)
}