package com.powersoft.miuexamprep.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.powersoft.miuexamprep.adapters.ResultAdapter
import com.powersoft.miuexamprep.databinding.ActivityResultBinding
import com.powersoft.miuexamprep.listeners.AnimationEndListener
import com.powersoft.miuexamprep.model.MCQ
import com.powersoft.miuexamprep.utils.AnimUtils

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val typeToken = object : TypeToken<List<MCQ>>() {}.type
        val questionList =
            Gson().fromJson<List<MCQ>>(intent.getStringExtra("questionList"), typeToken)

        println("Question List size: " + questionList.size)

        binding.toolbar.tvTitle.text = "Quiz Result"
        binding.toolbar.imgBack.setOnClickListener {
            AnimUtils.bounce(it, object : AnimationEndListener {
                override fun onAnimationEnd() {
                    this@ResultActivity.onBackPressed()
                }
            })
        }


        val adapter = ResultAdapter(questionList)
        binding.rcvResult.layoutManager = LinearLayoutManager(this)
        binding.rcvResult.adapter = adapter
    }
}