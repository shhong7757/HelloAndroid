package com.example.helloandroid.data.presetTimer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preset_timer")
data class PresetTimer(
    @PrimaryKey
    val uid: Int,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "hour")
    val hour: Number?,

    @ColumnInfo(name = "minute")
    val minute: Number?,

    @ColumnInfo(name = "second")
    val second: Number?,
)