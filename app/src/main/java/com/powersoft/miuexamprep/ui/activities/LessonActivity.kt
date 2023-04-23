package com.powersoft.miuexamprep.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.powersoft.miuexamprep.db.AppDatabase
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding
import kotlinx.coroutines.launch

class LessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            AppDatabase.invoke(this@LessonActivity).lessonDao().getLessons(10)
        }
    }
}