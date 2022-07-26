package com.example.helloandroid.ui.combinePresetTimer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.NumberPicker
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.helloandroid.databinding.FragmentCreateNewPresetTimerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText

class CreateNewPresetTimerFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentCreateNewPresetTimerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val createPresetTimerViewModel =
            ViewModelProvider(this).get(CreateNewPresetTimerViewModel::class.java)

        _binding = FragmentCreateNewPresetTimerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val hourPicker: NumberPicker = binding.presetTimerHourPicker
        hourPicker.maxValue = 24
        hourPicker.minValue = 0
        hourPicker.value = 0
        hourPicker.setOnValueChangedListener { _, _, i2 ->
            createPresetTimerViewModel.changeValue(TimerValueType.HOUR, i2)
        }

        val minutePicker: NumberPicker = binding.presetTimerMinutePicker
        minutePicker.maxValue = 60
        minutePicker.minValue = 0
        minutePicker.value = 0
        minutePicker.setOnValueChangedListener { _, _, i2 ->
            createPresetTimerViewModel.changeValue(TimerValueType.MINUTE, i2)
        }

        val secondPicker: NumberPicker = binding.presetTimerSecondPicker
        secondPicker.maxValue = 60
        secondPicker.minValue = 0
        secondPicker.value = 0
        secondPicker.setOnValueChangedListener { _, _, i2 ->
            createPresetTimerViewModel.changeValue(TimerValueType.SECOND, i2)
        }

        createPresetTimerViewModel.submittable.observe(
            this
        ) { value ->
            val submitButton: ImageButton = binding.savePresetTimerButton
            submitButton.isClickable = value
        }

        val titleInput: TextInputEditText = binding.createPresetTimerTextInput
        titleInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
                val text = titleInput.text.toString()
                createPresetTimerViewModel.changeTitle(text)
            }
        })

        return root
    }

    companion object {
        const val TAG = "CreatePresetTimerBottomSheet"
    }
}