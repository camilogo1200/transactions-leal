package com.leal.camilogo1200.androidtest.ui.fragments

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.leal.camilogo1200.androidtest.R
import com.leal.camilogo1200.androidtest.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenFragment : Fragment() {

    private lateinit var _binding: FragmentSplashScreenBinding
    private lateinit var alphaFadeInAnimation: Animation
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        // Inflate the layout for this fragment
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        startAppIntroAnimation()
        return _binding.root
    }

    private fun startAppIntroAnimation() {
        alphaFadeInAnimation =
            AnimationUtils.loadAnimation(requireActivity(), R.anim.splash_anim_01)
        lifecycleScope.launch(Dispatchers.Main) {
            val transition: TransitionDrawable = _binding.root.background as TransitionDrawable
            transition.startTransition(1500)
            _binding.logoLealSplashScreen.animation = alphaFadeInAnimation
            _binding.mainTransactionsTitleText.animation = alphaFadeInAnimation
            _binding.logoLealSplashScreen.visibility = View.VISIBLE
            delay(1500)
            findNavController().navigate(R.id.action_splashScreenFragment_to_transactionsListFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}