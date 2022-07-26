package com.example.helloandroid.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.helloandroid.data.presetTimer.PresetTimer
import com.example.helloandroid.data.presetTimer.PresetTimerDao

@Database(entities = [PresetTimer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun presetTimerDao(): PresetTimerDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "preset_timer"
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }
    }
}