package com.powersoft.miuexamprep.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.utils.BackgroundShades
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class LessonAdapter: RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    var lessons: List<Lesson> = listOf()
    var course: Course? = null

    class LessonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvLessonName: TextView = itemView.findViewById(R.id.tvLessonName)
        val tvLessonQuestionNum: TextView = itemView.findViewById(R.id.tvLessonQuestionNum)
        val tvLessonCompletion: TextView = itemView.findViewById(R.id.tvLessonCompletion)
        val tvLessonDescription: TextView = itemView.findViewById(R.id.tvLessonDescription)
        val imgLessson: ImageView = itemView.findViewById(R.id.imgLesson)
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
            tvLessonName.text = lesson.name
            tvLessonQuestionNum.text = lesson.activitiesCount.toString()
            tvLessonCompletion.text = String.format("%.2f", lesson.percentageComplete)
            tvLessonDescription.text = getDate()
            itemView.setOnClickListener {
                Toast.makeText(it.context, "lesson is clicked", Toast.LENGTH_SHORT).show()
            }
        }

        if (course != null) {
            holder.imgLessson.setImageResource(course!!.icon)
            val bg = BackgroundShades()
            holder.imgLessson.setBackgroundResource(bg[position % bg.size])
        }
    }

    private fun getDate(): String{
        var dt = Date()
        val c: Calendar = Calendar.getInstance()
        c.setTime(dt)
        c.add(Calendar.DATE, 7)
        dt = c.getTime()
        val format = SimpleDateFormat("MM/dd/yyyy")
        return format.format(dt)
    }
}