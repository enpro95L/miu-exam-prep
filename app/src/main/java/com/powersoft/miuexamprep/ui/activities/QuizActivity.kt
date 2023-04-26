package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.powersoft.miuexamprep.adapters.OptionAdapter
import com.powersoft.miuexamprep.databinding.ActivityQuizBinding
import com.powersoft.miuexamprep.listeners.AnimationEndListener
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.model.MCQ
import com.powersoft.miuexamprep.utils.AnimUtils
import com.powersoft.miuexamprep.view_models.McqViewModel
import kotlinx.coroutines.launch

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private var optionList = listOf<String>()
    private var questionList = listOf<MCQ>()
    private lateinit var optionAdapter: OptionAdapter
    private lateinit var course: Course
    private lateinit var lesson: Lesson

    private lateinit var viewModel: McqViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        course = intent.getSerializableExtra("course") as Course
        lesson = intent.getSerializableExtra("lesson") as Lesson

        binding.toolbar.tvTitle.text = lesson.name
        binding.toolbar.imgBack.setOnClickListener {
            AnimUtils.bounce(it, object : AnimationEndListener {
                override fun onAnimationEnd() {
                    this@QuizActivity.onBackPressed()
                }
            })
        }
        viewModel = ViewModelProvider(this)[McqViewModel::class.java]

        viewModel.questionList.observe(this) { value ->
            questionList = value
            if (questionList.isEmpty()) {
                Toast.makeText(this@QuizActivity, "No question available", Toast.LENGTH_SHORT)
                    .show()
                finish()
            } else {
                showQuiz()
            }
        }

        lifecycleScope.launch {
            viewModel.getQuestions(course.id, lesson.id)
        }

        binding.btnSubmit.setOnClickListener {
            calculatePoints()
        }

        binding.tvNext.setOnClickListener {
            viewModel.increaseCurrentIndex()
            showQuiz()
            if (viewModel.getCurrentIndex() == questionList.size - 1) {
                binding.tvNext.visibility = View.GONE
                binding.btnSubmit.visibility = View.VISIBLE
            }
        }
    }

    private fun calculatePoints() {
        var currentCount = 0
        questionList.forEach {
            if (it.selectedAnswer == it.correctAnswer) currentCount++
        }
        Toast.makeText(this, "Correct count: $currentCount", Toast.LENGTH_SHORT).show()
        val i = Intent(this, ResultActivity::class.java)
        i.putExtra("questionList", Gson().toJson(questionList))
        startActivity(i)

        val returnIntent = Intent()
        val percentageComplete = (currentCount.toDouble()/questionList.size) * 100
        lesson.percentageComplete = percentageComplete.toFloat()
        returnIntent.putExtra("lesson", lesson)
        setResult(RESULT_OK, returnIntent)
        finish()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showQuiz() {
        val question = questionList[viewModel.getCurrentIndex()].question
        binding.tvQuestion.text = question
        optionList = questionList[viewModel.getCurrentIndex()].optionList

        optionAdapter = OptionAdapter(optionList, viewModel)
        binding.recyclerViewOption.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewOption.adapter = optionAdapter

        binding.tvCurrentQuestion.text = String.format("%d", viewModel.getCurrentIndex() + 1)
        binding.tvTotalQuestion.text = String.format("/%d", questionList.size)
    }
}