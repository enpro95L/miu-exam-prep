package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.powersoft.miuexamprep.adapters.LessonAdapter
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding
import com.powersoft.miuexamprep.listeners.AnimationEndListener
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.MCQ
import com.powersoft.miuexamprep.utils.AnimUtils
import com.powersoft.miuexamprep.view_models.LessonViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonBinding
    private lateinit var viewModel: LessonViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val course = intent.getSerializableExtra("course") as Course

        binding.toolbar.tvTitle.text = course.name
        binding.toolbar.imgBack.setOnClickListener {
            AnimUtils.bounce(it, object : AnimationEndListener {
                override fun onAnimationEnd() {
                    this@LessonActivity.onBackPressed()
                }
            })
        }

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[LessonViewModel::class.java]

        val adapter = LessonAdapter(course)
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch(Dispatchers.IO) {
            val lessons = viewModel.getCourseLessons(course.id)
            adapter.lessons = lessons
            adapter.notifyDataSetChanged()
        }
    }
}