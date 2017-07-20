package com.example.personale.firebaseim.di.login

import com.example.personale.firebaseim.login.LoginActivity
import dagger.Subcomponent
import javax.inject.Scope

/**
 * Created by personale on 7/18/17.
 */

@LoginScope
@Subcomponent(modules = arrayOf(LoginModule::class))
interface LoginComponent {
    fun inject(target: LoginActivity)
}

@Scope
annotation class LoginScope
