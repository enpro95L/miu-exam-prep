package com.powersoft.miuexamprep.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.databinding.ItemLessonBinding
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.ui.activities.QuizActivity
import com.powersoft.miuexamprep.utils.BackgroundShades
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class LessonAdapter(val course: Course) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    var lessons: List<Lesson> = listOf()
    val bg = BackgroundShades()

    inner class LessonViewHolder(private val binding: ItemLessonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lesson: Lesson) {
            binding.tvLessonName.text = lesson.name
            binding.tvLessonQuestionNum.text = String.format("%d Questions", lesson.totalQuestion)
            binding.tvLessonCompletion.text = String.format("%.2f", lesson.percentageComplete)
            binding.imgLesson.setImageResource(course.icon)
            binding.imgLesson.setBackgroundResource(bg[position % bg.size])

<<<<<<< HEAD
        holder.apply {
            tvLessonName.text = lesson.name
            tvLessonQuestionNum.text = lesson.activitiesCount.toString()
            tvLessonCompletion.text = String.format("%.2f", lesson.percentageComplete)
            tvLessonDescription.text = getDate()
=======
>>>>>>> 45cb7d2394be92ef157b8365bc7038cda25dc991
            itemView.setOnClickListener {
                binding.root.context.let {
                    val intent = Intent(it, QuizActivity::class.java)
                    intent.putExtra("course", course)
                    intent.putExtra("lesson", lesson)
                    it.startActivity(intent)
                }
            }
        }
    }

<<<<<<< HEAD
    private fun getDate(): String{
        var dt = Date()
        val c: Calendar = Calendar.getInstance()
        c.setTime(dt)
        c.add(Calendar.DATE, 7)
        dt = c.getTime()
        val format = SimpleDateFormat("MM/dd/yyyy")
        return format.format(dt)
    }
=======
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LessonViewHolder(
            ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = lessons.size

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) =
        holder.bind(lessons[position])
>>>>>>> 45cb7d2394be92ef157b8365bc7038cda25dc991
}