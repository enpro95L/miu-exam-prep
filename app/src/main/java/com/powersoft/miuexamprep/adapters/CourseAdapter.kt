package com.powersoft.miuexamprep.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.listeners.AnimationEndListener
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.ui.activities.LessonActivity
import com.powersoft.miuexamprep.utils.AnimUtils

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    var courses: List<Course> = listOf()
    var bg = listOf(
        R.drawable.grad_chap_1,
        R.drawable.grad_chap_2,
        R.drawable.grad_chap_3,
        R.drawable.grad_chap_4,
        R.drawable.grad_chap_5,
        R.drawable.grad_chap_6,
        R.drawable.grad_chap_7,
        R.drawable.grad_chap_8
    )

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCourseName: TextView = itemView.findViewById(R.id.tvCourseName)
        private val imgCourse: ImageView = itemView.findViewById(R.id.imgCourseIcon)
        private val rootView: View = itemView.findViewById(R.id.root)

        fun bind(course: Course) {
            tvCourseName.text = course.name
            imgCourse.setImageResource(course.icon)
            rootView.setBackgroundResource(bg[position % bg.size])

            rootView.setOnClickListener {
                val context = it.context
                it.startAnimation(AnimUtils.bounce(rootView.context, object : AnimationEndListener {
                    override fun onAnimationEnd() {
                        val intent = Intent(context, LessonActivity::class.java)
                        intent.putExtra("course", course)
                        context.startActivity(intent)
                    }
                }))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.course_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.bind(course)
    }
}