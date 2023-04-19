package com.powersoft.miuexamprep.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.powersoft.miuexamprep.databinding.ActivityLessonBinding

class LessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}