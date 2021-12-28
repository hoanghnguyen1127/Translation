package com.example.translation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var langPreference: LanguagePreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_SetLanguage = findViewById(R.id.btn_setlanguage) as Button
        btn_SetLanguage.setOnClickListener{
            startActivity(Intent(
                this,
                SettingLanguage::class.java
            ))
        }

    }

    override fun attachBaseContext(newBase: Context?) {
        langPreference = LanguagePreference(newBase!!)
        val lang: String? = langPreference.getLoginCount()
        super.attachBaseContext(lang?.let { LanguageContextWrapper.wrap(newBase, it) })
    }
}