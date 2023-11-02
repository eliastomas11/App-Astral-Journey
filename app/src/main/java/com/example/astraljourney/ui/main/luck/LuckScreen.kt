package com.example.astraljourney.ui.main.luck

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.astraljourney.R
import com.example.astraljourney.databinding.FragmentLuckScreenBinding
import com.example.astraljourney.ui.main.common.listener.OnSwipeTouchListener
import com.example.astraljourney.ui.main.providers.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class LuckScreen : Fragment() {

    private var _binging: FragmentLuckScreenBinding? = null
    private val binding get() = _binging!!

    @Inject lateinit var randomCardProvider: RandomCardProvider

    private val luckViewModel by viewModels<LuckViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binging = FragmentLuckScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()
    }

    private fun initUI() {
        preparePrediction()
        initListeners()
    }

    private fun preparePrediction() {
        val luck = randomCardProvider.getLucky()
        luck?.let { content ->
            binding.tvPrediction.text = getString(content.prediction)
            binding.ivLuckCard.setImageResource(content.image)
            binding.btnShare.setOnClickListener {
                shareResult(getString(content.prediction))
            }
        }
    }

    private fun shareResult(prediction: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,prediction)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(intent,null)
        startActivity(shareIntent)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListeners() {
        binding.roulette.setOnTouchListener(object : OnSwipeTouchListener(requireContext()) {
            override fun onSwipeRight() {
                spinRoulette()
            }

            override fun onSwipeLeft() {
                spinRoulette()
            }
        })
    }

    private fun spinRoulette() {
        val random = Random()
        val degrees = random.nextInt(1440) + 360
        val animator = ObjectAnimator.ofFloat(binding.roulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard(){
        val slideUpAnim = AnimationUtils.loadAnimation(requireActivity(), R.anim.slide_up)
        slideUpAnim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                binding.reverseCard.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(p0: Animation?) {
                growAnimation()
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })
        binding.reverseCard.startAnimation(slideUpAnim)
    }

    private fun growAnimation(){
        val growUpAnim = AnimationUtils.loadAnimation(requireActivity(), R.anim.grow)
        growUpAnim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.reverseCard.visibility = View.GONE
                showPrediction()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })
        binding.reverseCard.startAnimation(growUpAnim)
    }

    private fun showPrediction(){
        val disappearAnim = AlphaAnimation(1.0f, 0.0f)
        disappearAnim.duration = 200
        disappearAnim.setAnimationListener( object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.preview.visibility = View.INVISIBLE
                binding.prediction.visibility = View.VISIBLE
                binding.btnShare.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })

        binding.preview.startAnimation(disappearAnim)
        appearAnim()
    }

    private fun appearAnim(){
        val appearAnim = AlphaAnimation(0.0f, 1.0f)
        appearAnim.duration = 1000
        binding.prediction.startAnimation(appearAnim)

    }

}