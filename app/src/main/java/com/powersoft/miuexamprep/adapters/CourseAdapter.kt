package com.powersoft.miuexamprep.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.model.Course

class CourseAdapter: RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    var courses: List<Course> = listOf()
    class CourseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvCourseName: TextView = itemView.findViewById(R.id.tvCourseName)
        val imgCourse: ImageView = itemView.findViewById(R.id.imgCourseIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.course_view, parent, false))
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.apply {
            tvCourseName.text = course.name
            imgCourse.setImageResource(course.icon)

            itemView.setOnClickListener {
                //Perform appropriate view navigation here
            }
        }
    }
}