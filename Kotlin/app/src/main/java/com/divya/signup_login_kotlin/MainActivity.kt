package com.divya.signup_login_kotlin

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var userViewModel: UserViewModel? = null
    private var usernameText: EditText? = null
    private var passwordText: EditText? = null
    private var signUpButton: Button? = null
    private var loginButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usernameText = findViewById<View>(R.id.username) as EditText
        passwordText = findViewById<View>(R.id.password) as EditText
        signUpButton = findViewById<View>(R.id.signup) as Button
        loginButton = findViewById<View>(R.id.login) as Button

        userViewModel = ViewModelProviders.of(this, UserViewModel.Factory(applicationContext)).get(UserViewModel::class.java)

        val signup = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
                .getBoolean("signup", true)

        if (signup) {
            signUpButton!!.visibility = View.VISIBLE
            loginButton!!.visibility = View.GONE
        } else {
            signUpButton!!.visibility = View.GONE
            loginButton!!.visibility = View.VISIBLE

        }
        signUpButton!!.setOnClickListener {
            userViewModel!!.createUser(usernameText!!.text.toString(), passwordText!!.text.toString())
            getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                    .putBoolean("signup", false).commit()
            Toast.makeText(baseContext, "Successfully Created An Account!", Toast.LENGTH_LONG).show()
        }

        loginButton!!.setOnClickListener {
            val isValid = userViewModel!!.checkValidLogin(usernameText!!.text.toString(), passwordText!!.text.toString())
            if (isValid) {
                Toast.makeText(baseContext, "Successfully Logged In!", Toast.LENGTH_LONG).show()
                Log.i("Successful_Login", "Login was successful")
            } else {
                Toast.makeText(baseContext, "Invalid Login!", Toast.LENGTH_SHORT).show()
                Log.i("Unsuccessful_Login", "Login was not successful")
            }
        }

    }

}
