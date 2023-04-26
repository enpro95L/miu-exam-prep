package com.powersoft.miuexamprep.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.databinding.ItemLessonBinding
import com.powersoft.miuexamprep.listeners.OnItemClickListener
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.ui.activities.LessonActivity
import com.powersoft.miuexamprep.ui.activities.QuizActivity
import com.powersoft.miuexamprep.utils.BackgroundShades

class LessonAdapter(val course: Course) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    var lessons: List<Lesson> = listOf()
    val bg = BackgroundShades()
    private var onClickListener: OnItemClickListener? = null

    inner class LessonViewHolder(private val binding: ItemLessonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lesson: Lesson) {
            binding.tvLessonName.text = lesson.name
            binding.progressCompletion.progress = lesson.percentageComplete.toInt()
            binding.tvLessonQuestionNum.text = String.format("%d Questions", lesson.totalQuestion)
            binding.tvLessonCompletion.text = String.format("%.2f%s", lesson.percentageComplete, "%")
            binding.imgLesson.setImageResource(course.icon)
            binding.imgLesson.setBackgroundResource(bg[position % bg.size])

            itemView.setOnClickListener {
                if (onClickListener != null) {
                    onClickListener!!.onClicked(lesson, course)
                }
            }
        }
    }

    fun setOnClickListener(onClickListener: OnItemClickListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LessonViewHolder(
            ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = lessons.size

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) =
        holder.bind(lessons[position])
}