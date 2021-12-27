package com.example.translation

import android.content.Context
import android.content.SharedPreferences


val PRE_NAME = "LanguageTranslation"
val PRE_LANGUAGE = "Language"
class LanguagePreference(context: Context) {
    val preference: SharedPreferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)

    fun getLoginCount() : String? {
        return preference.getString(PRE_LANGUAGE, "en")
    }

    fun setLoginCount(Language: String){
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString(PRE_LANGUAGE, Language)
        editor.apply()
    }
}