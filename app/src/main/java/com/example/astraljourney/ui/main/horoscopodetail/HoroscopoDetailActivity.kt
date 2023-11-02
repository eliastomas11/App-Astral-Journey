package com.example.astraljourney.ui.main.horoscopodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.astraljourney.R
import com.example.astraljourney.databinding.ActivityHoroscopoDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoDetailBinding
    private val horoscopoDetailViewModel by viewModels<HoroscopoDetailViewModel>()
    private val navArgs by navArgs<HoroscopoDetailActivityArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initUiState()
        initListeners()
    }

    private fun initListeners() {
        binding.detailToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            horoscopoDetailViewModel.onInitialize(navArgs.type)
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoDetailViewModel.detailUiState.collect{ uiState ->
                    binding.progressBar.visibility = if (uiState.loading) View.VISIBLE else View.GONE
                    binding.tvDetailTitle.text = uiState.title
                    binding.tvDetailDescription.text = uiState.description
                }
            }
        }
    }


}