package com.example.herocollection.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainVMFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainVM::class.java)) {
            MainVM(context.applicationContext) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")

        }
    }
}