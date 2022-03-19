package com.example.task11

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {
    var string = ""

    val currentString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}