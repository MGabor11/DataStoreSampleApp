package com.mgabor.datastoresampleapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mgabor.datastoresampleapp.R
import com.mgabor.datastoresampleapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main, container, false
        )

        binding.toFormButton.setOnClickListener {
            findNavController().navigate(R.id.navDirectionForm)
        }

        binding.toDetailButton.setOnClickListener {
            findNavController().navigate(R.id.navDirectionDetail)
        }

        return binding.root
    }
}
