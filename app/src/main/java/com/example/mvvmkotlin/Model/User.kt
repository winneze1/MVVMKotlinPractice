package com.example.mvvmkotlin.Model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable


class User (private var email:String, private var password:String) : BaseObservable() {
    fun isValidData() : Int
    {
        if(TextUtils.isEmpty(getEmail()))
            return 0
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1
        else if(password.length < 7)
            return 2
        else
            return -1
    }

     fun getPassword(): String {
        return password
    }

     fun getEmail(): String {
        return email
    }

    fun setEmail(email:String)
    {
        this.email = email
    }

    fun setPassword(pass:String)
    {
        this.password = password
    }


}