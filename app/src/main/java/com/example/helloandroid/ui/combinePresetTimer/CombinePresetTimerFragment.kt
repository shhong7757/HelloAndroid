package com.example.helloandroid.ui.combinePresetTimer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.helloandroid.databinding.FragmentCombinePresetTimerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CombinePresetTimerFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentCombinePresetTimerBinding? = null
    private lateinit var manager: FragmentManager

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCombinePresetTimerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        manager = childFragmentManager

        val transaction = manager.beginTransaction()
        transaction.add(root.id, PresetTimerListFragment())
        transaction.commit()

        return root
    }

    fun replaceFragment() {
        val root: View = binding.root
        val transaction = manager.beginTransaction()
        transaction.replace(root.id, CreateNewPresetTimerFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        const val TAG = "CreatePresetTimerBottomSheet"
    }
}