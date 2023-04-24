package com.powersoft.miuexamprep.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(@PrimaryKey var id: Int, var name: String, @DrawableRes var icon: Int) : java.io.Serializable
