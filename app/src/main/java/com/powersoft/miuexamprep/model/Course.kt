package com.powersoft.miuexamprep.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "course_name") var courseName: String,
    var icon: String
) : java.io.Serializable
