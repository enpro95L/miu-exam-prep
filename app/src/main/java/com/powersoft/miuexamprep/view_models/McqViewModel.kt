package com.powersoft.miuexamprep.view_models

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _questionList = MutableLiveData<List<MCQ>>()
    val questionList: LiveData<List<MCQ>> = _questionList

    private var currentIndex = 0

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

    fun increaseCurrentIndex(){
        currentIndex++
    }

    fun getCurrentIndex() = currentIndex

    suspend fun getQuestions(courseId: Int, lessonId: Int) {
        val list = repo.getQuestions(courseId, lessonId)
        _questionList.postValue(list)
    }
    fun updateQuestion(answer: String){
        _questionList.value?.apply {
            get(currentIndex).selectedAnswer = answer
        }
    }

    fun updateMCQ(mcq: MCQ) = viewModelScope.launch(Dispatchers.IO) {
        repo.add(mcq)
    }
}