package com.example.helloandroid.data.presetTimer

import android.content.Context
import com.example.helloandroid.data.AppDatabase

class PresetTimerRepository(context: Context) {

    var db: PresetTimerDao = AppDatabase.getInstance(context)?.presetTimerDao()!!

    fun getAllPresetTimers(): List<PresetTimer> {
        return db.getAll()
    }

    fun insertPresetTimer(presetTimer: PresetTimer) {
        db.insert(presetTimer)
    }

    fun deletePresetTimer(presetTimer: PresetTimer) {
        db.delete(presetTimer)
    }
}