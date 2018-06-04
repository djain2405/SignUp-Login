package com.divya.signup_login_kotlin

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context

import com.divya.rememberyourpasswords.data.UserAccountDatabase
import com.divya.rememberyourpasswords.data.UserRepository

/**
 * Created by divya on 5/16/2018.
 */

class UserViewModel(context: Context) : ViewModel() {

    private val userRepository: UserRepository

    init {

        userRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao())
    }

    internal fun createUser(username: String, password: String) {
        userRepository.insertUser(username, password)
    }

    internal fun checkValidLogin(username: String, password: String): Boolean {
        return userRepository.isValidAccount(username, password)
    }

    class Factory internal constructor(ctxt: Context) : ViewModelProvider.Factory {
        private val ctxt: Context

        init {
            this.ctxt = ctxt.applicationContext
        }

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(ctxt) as T
        }
    }
}
