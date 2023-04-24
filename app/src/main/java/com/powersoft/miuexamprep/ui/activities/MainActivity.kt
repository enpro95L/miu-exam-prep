package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.powersoft.miuexamprep.adapters.CourseAdapter
import com.powersoft.miuexamprep.databinding.ActivityMainBinding
import com.powersoft.miuexamprep.view_models.CourseViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CourseViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvUsername.text = intent.getStringExtra("username")

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[CourseViewModel::class.java]

        val adapter = CourseAdapter()
        binding.rcv.adapter = adapter

        viewModel.courses.observe(this) { courses ->
            courses?.let {
                adapter.courses = courses
                adapter.notifyDataSetChanged()
            }
        }
    }

}