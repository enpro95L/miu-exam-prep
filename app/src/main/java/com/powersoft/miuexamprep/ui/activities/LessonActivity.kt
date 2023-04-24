package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.powersoft.miuexamprep.adapters.LessonAdapter
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.view_models.LessonViewModel

class LessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonBinding
    private lateinit var viewModel: LessonViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val course = intent.getSerializableExtra("course") as Course

        Toast.makeText(this, "${course.id}", Toast.LENGTH_SHORT).show()

        binding.toolbar.tvTitle.text = course.name

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(LessonViewModel::class.java)

        viewModel.setCourseId(course.id)

        val adapter = LessonAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.courseLessons.observe(this) { lessons ->
            lessons?.let {
                adapter.lessons = lessons
                adapter.notifyDataSetChanged()
            }
        }
    }
}