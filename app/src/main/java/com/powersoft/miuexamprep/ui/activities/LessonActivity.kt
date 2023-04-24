package com.powersoft.miuexamprep.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.powersoft.miuexamprep.db.AppDatabase
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding
import com.powersoft.miuexamprep.model.Course
import kotlinx.coroutines.launch

class LessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val course = intent.getSerializableExtra("course") as Course
        Toast.makeText(this, "${course.id}", Toast.LENGTH_SHORT).show()

        binding.toolbar.tvTitle.text = course.name

        lifecycleScope.launch {
            AppDatabase.invoke(this@LessonActivity).lessonDao().getLessons(10)
        }
    }
}