package com.powersoft.miuexamprep.view_models

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.powersoft.miuexamprep.db.AppDatabase
import com.powersoft.miuexamprep.db.repositories.MCQRepository
import com.powersoft.miuexamprep.db.seeders.DatabaseSeeder
import com.powersoft.miuexamprep.db.seeders.MCQSeeder
import com.powersoft.miuexamprep.model.MCQ
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class McqViewModel(application: Application): AndroidViewModel(application) {
    private val repo: MCQRepository

    init {
        repo = MCQRepository(AppDatabase(application).mcqDao())

        if (repo.count.value != MCQSeeder.getMCQs().size) {
            initializeMcqs(application)
        }
    }

    private fun initializeMcqs(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseSeeder.runMcqsSeeder(context)
        }
    }

    suspend fun mcqs(courseId: Int, lessonId: Int): List<MCQ> {
        return repo.mcqs(courseId, lessonId)
    }

    fun updateMCQ(mcq: MCQ) = viewModelScope.launch(Dispatchers.IO) {
        repo.add(mcq)
    }
}