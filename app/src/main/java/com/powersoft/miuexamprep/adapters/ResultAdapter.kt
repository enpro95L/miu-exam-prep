package com.powersoft.miuexamprep.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.model.MCQ

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {
    var questionList: List<MCQ> = listOf()

    inner class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvQuestoin: TextView = itemView.findViewById(R.id.tvResultQuestion)
        private val tvYourAns: TextView = itemView.findViewById(R.id.tvYourAns)
        private val tvCorrectAns: TextView = itemView.findViewById(R.id.tvCorrectAns)

        fun bind(mcq: MCQ) {
            tvQuestoin.text = mcq.question
            tvYourAns.text = mcq.selectedAnswer
            tvCorrectAns.text = mcq.correctAnswer
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultAdapter.ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: ResultAdapter.ResultViewHolder, position: Int) {
        var question = questionList[position]
        holder.bind(question)
    }

}