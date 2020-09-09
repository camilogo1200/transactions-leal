package com.leal.camilogo1200.androidtest.fragments

import android.graphics.drawable.TransitionDrawable
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        // Inflate the layout for this fragment
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        alphaFadeInAnimation =
            AnimationUtils.loadAnimation(requireActivity(), R.anim.splash_anim_01)
        lifecycleScope.launch(Dispatchers.Main) {
            val transition: TransitionDrawable = _binding.root.background as TransitionDrawable
            transition.startTransition(2000)
            _binding.logoLealSplashScreen.animation = alphaFadeInAnimation
            _binding.mainTransactionsTitleText.animation = alphaFadeInAnimation
            delay(2000)
            _binding.logoLealSplashScreen.visibility = View.VISIBLE
            findNavController().navigate(R.id.action_splashScreenFragment_to_transactionsListFragment)
        }
        return _binding.root

    }

}