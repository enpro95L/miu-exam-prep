package com.powersoft.miuexamprep.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.powersoft.miuexamprep.db.AppDatabase
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.view_models.CourseViewModel
import com.powersoft.miuexamprep.view_models.LessonViewModel
import kotlinx.coroutines.launch

class LessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLessonBinding
    private lateinit var viewModel: LessonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[LessonViewModel::class.java]

        val course = intent.getSerializableExtra("course") as Course

        viewModel.setCourseId(course.id)

        Toast.makeText(this, "${course.id}", Toast.LENGTH_SHORT).show()

        binding.toolbar.tvTitle.text = course.name

        viewModel.courseLessons.observe(this){courseLessons ->

        }
    }
}