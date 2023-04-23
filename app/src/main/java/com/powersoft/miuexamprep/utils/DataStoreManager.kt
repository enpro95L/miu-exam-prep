package com.powersoft.miuexamprep.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object DataStoreManager {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "MIU_QUIZ_DATASTORE")

    private object PreferenceKeys {
        val NAME = stringPreferencesKey("NAME")
        val EMAIL = stringPreferencesKey("EMAIL")
    }

    suspend fun saveNameAndEmail(context: Context, name: String, email: String) {
        context.dataStore.edit {
            it[PreferenceKeys.NAME] = name
            it[PreferenceKeys.EMAIL] = email
        }
    }

    suspend fun getName(context: Context) = context.dataStore.data.first()[PreferenceKeys.NAME]

    suspend fun getEmail(context: Context) = context.dataStore.data.first()[PreferenceKeys.EMAIL]
}