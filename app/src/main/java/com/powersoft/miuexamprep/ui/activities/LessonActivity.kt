package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.powersoft.miuexamprep.adapters.LessonAdapter
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding
import com.powersoft.miuexamprep.viewModels.LessonViewModel

class LessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLessonBinding
    private lateinit var viewModel: LessonViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        lifecycleScope.launch {
//            AppDatabase.invoke(this@LessonActivity).lessonDao().getLessons(10)
//        }


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(LessonViewModel::class.java)

        val adapter = LessonAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.lessons.observe(this){lessons ->
            lessons?.let {
                adapter.lessons = lessons
                adapter.notifyDataSetChanged()
            }
        }
    }
}