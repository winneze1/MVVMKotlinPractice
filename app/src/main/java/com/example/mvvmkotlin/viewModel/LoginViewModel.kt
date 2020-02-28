package com.example.mvvmkotlin.viewModel

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlin.Interface.LoginResultCallBacks
import com.example.mvvmkotlin.Model.User

class LoginViewModel(private val listener: LoginResultCallBacks) : ViewModel() {
    private val user: User = User("", "")

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }

    fun onLoginClicked(v : View){
        var loginCode:Int = user.isValidData()
        Log.d("hello", user.getEmail())
        Log.d("hello2", user.getPassword())


        when (loginCode) {
            0 -> {
                listener.onError("Email must not be null")
            }
            1 -> {
                listener.onError("Wrong email pattern")
            }
            2 -> {
                listener.onError("Password Length must grater than 6")
            }
            else -> {
                listener.onSuccess("Login success")
            }
        }
        Log.d("logincode: ",loginCode.toString())

    }

}