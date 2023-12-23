package com.example.lovecalculate52_2.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate52_2.R
import com.example.lovecalculate52_2.databinding.FragmentResultBinding
import com.example.lovecalculate52_2.presenter.ParameterPresenter

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        initClickers()
        setParameters()

    }

    private fun initClickers() {
        binding.btnTryagain.setOnClickListener {
            findNavController().navigate(R.id.parameterFragment)
        }
    }

    private fun setParameters() {
        val percentage = arguments?.getString("percentage")
        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val result = arguments?.getString("result")

        with(binding) {
            tvPercentage.text = "$percentage%"
            tvFirstName.text = firstName
            tvSecondName.text = secondName
            tvResult.text = result
        }

    }


}
