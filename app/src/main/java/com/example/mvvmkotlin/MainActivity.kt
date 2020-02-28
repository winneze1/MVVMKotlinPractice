package com.example.mvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmkotlin.Interface.LoginResultCallBacks
import com.example.mvvmkotlin.viewModel.LoginViewModel
import com.example.mvvmkotlin.viewModel.LoginViewModelFactory
import com.example.mvvmkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoginResultCallBacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityMainBinding  = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProvider(this, LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}
