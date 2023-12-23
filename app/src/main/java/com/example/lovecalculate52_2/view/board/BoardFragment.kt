package com.example.lovecalculate52_2.view.board

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate.board.BoardAdapter
import com.example.lovecalculate52_2.Prefs
import com.example.lovecalculate52_2.R
import com.example.lovecalculate52_2.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment : Fragment() {

    var prefs: Prefs? = null
        @Inject set



    lateinit var binding: FragmentBoardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardAdapter(requireContext(), findNavController())
        binding.view.adapter = adapter
        binding.dots.setViewPager2(binding.view)
        binding.dots.setViewPager2(binding.view)

        binding.tvNext.setOnClickListener {
//            prefs?.saveState()
            findNavController().navigate(R.id.parameterFragment)

        }

    }
}