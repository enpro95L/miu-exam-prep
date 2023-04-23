package com.powersoft.miuexamprep.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.powersoft.miuexamprep.db.AppDatabase

abstract class BaseViewModel(context: Context): ViewModel() {
    protected val db = AppDatabase(context)
}