package com.leal.camilogo1200.androidtest.ui.fragments.transactionList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leal.camilogo1200.androidtest.databinding.FragmentTransactionsListBinding

class TransactionsListFragment : Fragment() {

    private lateinit var _binding: FragmentTransactionsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionsListBinding.inflate(inflater, container, false)
        return _binding.root
    }
}