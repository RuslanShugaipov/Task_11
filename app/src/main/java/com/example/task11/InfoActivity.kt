package com.example.task11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val surname = if (intent.getStringExtra(Constants.SURNAME).isNullOrEmpty())
            getString(R.string.defaultSurname) else intent.getStringExtra(Constants.SURNAME)

        val name = if (intent.getStringExtra(Constants.NAME).isNullOrEmpty())
            getString(R.string.defaultName) else intent.getStringExtra(Constants.NAME)

        val patronymic = if (intent.getStringExtra(Constants.PATRONYMIC).isNullOrEmpty())
            getString(R.string.defaultPatronymic) else intent.getStringExtra(Constants.PATRONYMIC)

        val age = intent.getIntExtra(Constants.AGE, 20)

        val hobby = if (intent.getStringExtra(Constants.HOBBY).isNullOrEmpty())
            getString(R.string.defaultHobby) else intent.getStringExtra(Constants.HOBBY)

        val youngDescription =
            "$surname $name $patronymic${getString(R.string.young_description)}$hobby."
        val adultDescription =
            "$surname $name $patronymic${getString(R.string.adult_description)}$hobby."
        val oldDescription =
            "$surname $name $patronymic${getString(R.string.old_description)}$hobby."

        tvDescription.text = ""
        if (age in 1..10)
            tvDescription.append(youngDescription)
        if (age in 10..49)
            tvDescription.append(adultDescription)
        if (age in 50..99)
            tvDescription.append(oldDescription)

        buttonBackToMain.setOnClickListener {
            finish()
        }
    }
}