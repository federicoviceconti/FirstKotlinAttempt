package com.example.personale.firebaseim.di.login

import com.example.personale.firebaseim.login.presenter.LoginPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by personale on 7/18/17.
 */

@Module
class LoginModule{
    @Provides
    @LoginScope
    fun providesLoginPresenter(): LoginPresenterImpl = LoginPresenterImpl()
}