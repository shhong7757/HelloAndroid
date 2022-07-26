package com.example.helloandroid.data.presetTimer

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PresetTimerDao {
    @Query("SELECT * FROM preset_timer")
    fun getAll(): List<PresetTimer>

    @Insert
    fun insert(presetTimer: PresetTimer)

    @Delete
    fun delete(presetTimer: PresetTimer)
}