package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.powersoft.miuexamprep.adapters.LessonAdapter
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding
import com.powersoft.miuexamprep.listeners.AnimationEndListener
import com.powersoft.miuexamprep.listeners.OnItemClickListener
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.utils.AnimUtils
import com.powersoft.miuexamprep.view_models.LessonViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonBinding
    private lateinit var viewModel: LessonViewModel
    private lateinit var adapter: LessonAdapter
    private var contract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val lesson = result.data?.getSerializableExtra("lesson") as Lesson
                viewModel.updateLesson(lesson)
            }
        }

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

        adapter = LessonAdapter(course)
        binding.recyclerView.adapter = adapter
        adapter.setOnClickListener(object : OnItemClickListener {
            override fun onClicked(lesson: Lesson, course: Course) {
                val intent = Intent(this@LessonActivity, QuizActivity::class.java)
                intent.putExtra("course", course)
                intent.putExtra("lesson", lesson)
                contract.launch(intent)
            }
        })

        lifecycleScope.launch(Dispatchers.IO) {
            val lessons = viewModel.getCourseLessons(course.id)
            adapter.lessons = lessons
            adapter.notifyDataSetChanged()
        }
    }
}