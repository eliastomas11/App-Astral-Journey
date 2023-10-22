package com.example.astraljourney.ui.main.luck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.astraljourney.databinding.FragmentLuckScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckScreen : Fragment() {

    private var _binging: FragmentLuckScreenBinding? = null
    private val binding get() = _binging!!

    private val luckViewModel by viewModels<LuckViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binging = FragmentLuckScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


}