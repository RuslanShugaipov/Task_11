package com.example.task11

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        buttonShowInfo.setOnClickListener {
            Intent(this, InfoActivity::class.java).also {
                it.putExtra(Constants.NAME, etName.text.toString())
                it.putExtra(Constants.SURNAME, etSurname.text.toString())
                it.putExtra(Constants.PATRONYMIC, etPatronymic.text.toString())
                it.putExtra(Constants.HOBBY, etHobby.text.toString())
                it.putExtra(Constants.AGE, etAge.text.toString().toIntOrNull())
                startActivity(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                saveData()
            }
            R.id.changeBackground -> {
                changeBackgroundImage()
            }
            R.id.changeActivity -> {
                startActivity(Intent(this, TestViewModelActivity::class.java))
            }
        }
        return true
    }

    private fun saveData() {
        val insertedSurname = etSurname.text.toString()
        val insertedName = etName.text.toString()
        val insertedPatronymic = etPatronymic.text.toString()
        val insertedAge = etAge.text.toString()
        val insertedHobby = etHobby.text.toString()

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("SURNAME_KEY", insertedSurname)
            putString("NAME_KEY", insertedName)
            putString("PATRONYMIC_KEY", insertedPatronymic)
            putString("AGE_KEY", insertedAge)
            putString("HOBBY_KEY", insertedHobby)
        }.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        etSurname.setText(sharedPreferences.getString("SURNAME_KEY", null))
        etName.setText(sharedPreferences.getString("NAME_KEY", null))
        etPatronymic.setText(sharedPreferences.getString("PATRONYMIC_KEY", null))
        etAge.setText(sharedPreferences.getString("AGE_KEY", null))
        etHobby.setText(sharedPreferences.getString("HOBBY_KEY", null))
    }

    private val backgroundImages = arrayOf(
        R.drawable.ic_background_beacon, R.drawable.ic_background_city,
        R.drawable.ic_background_road
    )

    private fun changeBackgroundImage() {
        val randomNumber = Random.nextInt(backgroundImages.size)
        main_layout.setBackgroundResource(backgroundImages[randomNumber])
    }
}