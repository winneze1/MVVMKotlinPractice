package com.example.mvvmkotlin.Interface

interface LoginResultCallBacks {
    fun onSuccess(message:String)
    fun onError(message:String)
}