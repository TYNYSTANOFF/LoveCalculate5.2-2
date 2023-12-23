package com.example.lovecalculate52_2.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculate52_2.App
import com.example.lovecalculate52_2.R
import com.example.lovecalculate52_2.databinding.FragmentHistoryBinding
import com.example.lovecalculate52_2.model.LoveModel
import com.example.lovecalculate52_2.model.room.LoveDao
import com.example.lovecalculate52_2.view.HistoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    lateinit var binding: FragmentHistoryBinding
    private val adapter = HistoryAdapter()

    @Inject
    lateinit var dao: LoveDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = dao.getAll()
        binding.recyclerView.adapter = adapter
        adapter.setList(list as ArrayList<LoveModel>)
//        list.forEach {
//            binding.historyTV.append("\n ${it.firstName} \n ${it.secondName} \n ${it.percentage} \n ${it.result} \n")

        onClickListenerAlert()

    }


    private fun onClickListenerAlert() {
        adapter.onLongClickListener = {
            val dialog = AlertDialog.Builder(context)
            dialog.setTitle("Удалить")
            dialog.setMessage("Вы точно хотите удалить данную совместимость")
            dialog.setPositiveButton("Да") { _, _ ->
                dao.delete(adapter.getItem(it))
                adapter.deleteItemsAndNotifyAdapter(it)
                binding.recyclerView.adapter = adapter
//                Delete items in RecyclerView**

            }
            dialog.setNegativeButton("Назад") { dialog, _ -> dialog.cancel() }.create().show()

        }

    }
}

