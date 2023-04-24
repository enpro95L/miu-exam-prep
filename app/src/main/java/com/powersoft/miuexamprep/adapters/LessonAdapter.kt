package com.powersoft.miuexamprep.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.model.Lesson

class LessonAdapter: RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    var lessons: List<Lesson> = listOf()
    class LessonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvLessonName: TextView = itemView.findViewById(R.id.tvLessonName)
        val tvLessonQuestionNum: TextView = itemView.findViewById(R.id.tvLessonQuestionNum)
        val tvLessonCompletion: TextView = itemView.findViewById(R.id.tvLessonCompletion)
        val tvLessonDescription: TextView = itemView.findViewById(R.id.tvLessonDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.apply {
            tvLessonName.text = lesson.lessonName
            tvLessonQuestionNum.text = lesson.totalQuestion.toString()
            tvLessonCompletion.text = String.format("%.2f", lesson.percentageComplete)
            tvLessonDescription.text = "Due on: this Friday"
            itemView.setOnClickListener {
                Toast.makeText(it.context, "lesson is clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}