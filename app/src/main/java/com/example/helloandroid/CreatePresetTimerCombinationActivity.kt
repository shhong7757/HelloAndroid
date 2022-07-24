package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.helloandroid.databinding.ActivityCreatePresetTimerCombinationBinding
import com.example.helloandroid.ui.combinePresetTimer.CombinePresetTimerFragment

class CreatePresetTimerCombinationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePresetTimerCombinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatePresetTimerCombinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: Button = binding.showCombinePresetTimerButton
        button.setOnClickListener {
            val bottomSheet = CombinePresetTimerFragment()
            bottomSheet.show(supportFragmentManager, CombinePresetTimerFragment.TAG)
        }
    }
}