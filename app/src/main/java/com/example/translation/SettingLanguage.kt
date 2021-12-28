package com.example.translation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class SettingLanguage : AppCompatActivity() {

    lateinit var langPreference: LanguagePreference

    val langList: Array<String> = arrayOf("en", "ar", "de", "es", "hi", "th", "vi", "zh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_language)

        langPreference = LanguagePreference(this)

        val spinner = findViewById<Spinner>(R.id.spinner)
        if(spinner != null){
            spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, langList)

            val lang: String? = langPreference.getLoginCount()
            val index: Int = langList.indexOf(lang)

            if(index >= 0){
                spinner.setSelection(index)
            }

            val btn_OK = findViewById(R.id.btn_ok) as Button
            btn_OK.setOnClickListener{
               langPreference.setLoginCount(langList[spinner.selectedItemPosition])
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}