package com.powersoft.miuexamprep.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(var name: String, @DrawableRes var icon: Int) : java.io.Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
