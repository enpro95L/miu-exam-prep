package com.powersoft.miuexamprep.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.powersoft.miuexamprep.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}