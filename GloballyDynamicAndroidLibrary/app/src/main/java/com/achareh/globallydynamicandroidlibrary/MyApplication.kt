/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.achareh.globallydynamicandroidlibrary

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import com.google.android.play.core.splitcompat.SplitCompat
import java.util.Locale

class MyApplication : Application() {
    override fun attachBaseContext(base: Context) {
        LanguageHelper.init(base)
        val ctx = LanguageHelper.getLanguageConfigurationContext(base)
        super.attachBaseContext(ctx)
        SplitCompat.install(this)
    }
}

internal const val LANG_EN = "en"

internal const val LANG_PL = "pl"

private const val PREFS_LANG = "language"

object LanguageHelper {
    lateinit var prefs: SharedPreferences
    var language: String
        get() {
            return prefs.getString(PREFS_LANG, LANG_EN)!!
        }
        set(value) {
            prefs.edit().putString(PREFS_LANG, value).apply()
        }

    fun init(ctx: Context){
        prefs = ctx.getSharedPreferences(PREFS_LANG, Context.MODE_PRIVATE)
    }

    fun getLanguageConfigurationContext(ctx: Context): Context {
        val conf = getLanguageConfiguration()
        return ctx.createConfigurationContext(conf)
    }

    fun getLanguageConfiguration(): Configuration {
        val conf = Configuration()
        conf.setLocale(Locale.forLanguageTag(language))
        return conf
    }

}