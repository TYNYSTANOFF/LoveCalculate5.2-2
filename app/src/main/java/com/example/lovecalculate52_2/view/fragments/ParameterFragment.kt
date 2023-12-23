package com.example.lovecalculate52_2.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate52_2.R
import com.example.lovecalculate52_2.databinding.FragmentParameterBinding
import com.example.lovecalculate52_2.model.LoveModel
import com.example.lovecalculate52_2.presenter.ParameterPresenter
import com.example.lovecalculate52_2.view.views.ParameterView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ParameterFragment : Fragment(), ParameterView {
    private lateinit var binding: FragmentParameterBinding

    @Inject
     lateinit var presenter: ParameterPresenter

    private val bundle = Bundle()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParameterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()
        hideEt()
        presenter.attachView(this)
    }


    private fun hideEt() {
        with(binding) {
            firstEd.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    firstEd.setHint("")
                } else {
                    firstEd.setHint("Man")
                }
            }
            secondEd.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    secondEd.setHint("")
                } else {
                    secondEd.setHint("Woman")
                }
            }

        }
    }

    override fun changeScreen(loveModel: LoveModel) {

        bundle.putString("percentage", loveModel.percentage)
        bundle.putString("firstName", loveModel.firstName)
        bundle.putString("secondName", loveModel.secondName)
        bundle.putString("result", loveModel.result)
        findNavController().navigate(R.id.resultFragment, bundle)


    }

    private fun initClicker() {
        binding.tvIconHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
        binding.btnCalculate.setOnClickListener {
            presenter.getData(binding.firstEd.text.toString(), binding.secondEd.text.toString())

        }
    }
}


