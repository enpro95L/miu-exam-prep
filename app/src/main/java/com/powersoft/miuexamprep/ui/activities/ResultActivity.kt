package com.powersoft.miuexamprep.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.adapters.ResultAdapter
import com.powersoft.miuexamprep.databinding.ActivityResultBinding
import com.powersoft.miuexamprep.listeners.AnimationEndListener
import com.powersoft.miuexamprep.model.MCQ
import com.powersoft.miuexamprep.utils.AnimUtils
import com.powersoft.miuexamprep.view_models.McqViewModel

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: McqViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val typeToken = object : TypeToken<List<MCQ>>() {}.type
        val questionList =
            Gson().fromJson<List<MCQ>>(intent.getStringExtra("questionList"), typeToken)

        println("Question List size: " + questionList.size)

        binding.toolbar.tvTitle.text = R.string.title_Result.toString()
//        binding.toolbar.imgBack.setOnClickListener {
//            AnimUtils.bounce(it, object : AnimationEndListener {
//                override fun onAnimationEnd() {
//                    this@ResultActivity.onBackPressed()
//                }
//            })
//        }


//        viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        )[McqViewModel::class.java]

        var adapter = ResultAdapter()
        binding.rcvResult.adapter = adapter

//        viewModel.questionList.observe(this) { mcqList ->
//            mcqList?.let {
//                adapter.questionList = mcqList
//                adapter.notifyDataSetChanged()
//            }
//        }


    }
}