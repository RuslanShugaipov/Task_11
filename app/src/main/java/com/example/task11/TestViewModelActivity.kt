package com.example.task11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_test_view_model.*

class TestViewModelActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view_model)

        viewModel = ViewModelProvider(this)[TestViewModel::class.java]

        viewModel.currentString.observe(this, Observer {
            textView.text = it
        })

        buttonReturn.setOnClickListener{
            finish()
        }

        buttonSave.setOnClickListener{
            viewModel.currentString.value = etRandomText.text.toString()
        }
    }
}