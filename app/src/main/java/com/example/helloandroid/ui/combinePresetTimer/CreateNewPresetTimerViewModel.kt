package com.example.helloandroid.ui.combinePresetTimer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class TimerValueType {
    HOUR,
    MINUTE,
    SECOND
}

class CreateNewPresetTimerViewModel : ViewModel() {
    private val _hour = MutableLiveData<Number>().apply {
        value = 0
    }
    private val _minute = MutableLiveData<Number>().apply {
        value = 0
    }
    private val _second = MutableLiveData<Number>().apply {
        value = 0
    }
    private val _submittable = MutableLiveData<Boolean>().apply {
        value = false
    }
    private val _title = MutableLiveData<String>().apply {
        value = ""
    }

    fun changeValue(type: TimerValueType, value: Number) {
        when (type) {
            TimerValueType.HOUR -> _hour.value = value
            TimerValueType.MINUTE -> _minute.value = value
            TimerValueType.SECOND -> _second.value = value
        }

        val h: Number = _hour.value ?: 0
        val m: Number = _minute.value ?: 0
        val s: Number = _second.value ?: 0
        val t: String = _title.value ?: ""

        _submittable.value =
            !(h == 0 && m == 0 && s == 0 && t !== "")
    }

    fun changeTitle(text: String) {

    }

    val title: LiveData<String> = _title
    val hour: LiveData<Number> = _hour
    val minute: LiveData<Number> = _minute
    val second: LiveData<Number> = _second
    val submittable: LiveData<Boolean> = _submittable

}