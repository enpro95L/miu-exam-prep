package com.powersoft.miuexamprep.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.databinding.ItemResultBinding
import com.powersoft.miuexamprep.model.MCQ

class ResultAdapter(val questionList: List<MCQ>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    inner class ResultViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mcq: MCQ, position: Int) {
            with(binding) {
                tvQuestionNo.text = "${position + 1}"
                tvResultQuestion.text = mcq.question
                tvYourAns.text = mcq.selectedAnswer
                tvCorrectAns.text = mcq.correctAnswer

                if (mcq.selectedAnswer == mcq.correctAnswer) {
                    tvYourAns.backgroundTintList =
                        ColorStateList.valueOf(binding.root.context.resources.getColor(R.color.green))
                } else {
                    tvYourAns.backgroundTintList =
                        ColorStateList.valueOf(binding.root.context.resources.getColor(R.color.red))
                }
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultAdapter.ResultViewHolder {
        return ResultViewHolder(
            ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = questionList.size

    override fun onBindViewHolder(holder: ResultAdapter.ResultViewHolder, position: Int) {
        val question = questionList[position]
        holder.bind(question, position)
    }

}