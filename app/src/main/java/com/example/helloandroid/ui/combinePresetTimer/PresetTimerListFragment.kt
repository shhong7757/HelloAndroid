package com.example.helloandroid.ui.combinePresetTimer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.helloandroid.databinding.FragmentPresetTimerListBinding

class PresetTimerListFragment : Fragment() {

    private var _binding: FragmentPresetTimerListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPresetTimerListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val button: Button = binding.createPresetTimerButton
        button.setOnClickListener {
            val parentFragment: CombinePresetTimerFragment =
                parentFragment as CombinePresetTimerFragment
            parentFragment.replaceFragment()
        }

        return root
    }
}