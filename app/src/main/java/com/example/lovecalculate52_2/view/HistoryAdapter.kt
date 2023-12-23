package com.example.lovecalculate52_2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculate52_2.databinding.ItemHistoryBinding
import com.example.lovecalculate52_2.model.LoveModel

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    var onLongClickListener: ((Int) -> Unit?)? = null
    var onClickListener: ((LoveModel) -> Unit?)? = null
    private var list = arrayListOf<LoveModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {


        holder.bind(list[position])
//        if (position == list.lastIndex) {
//            holder.itemView.visibility = GONE
////            viewHolder.itemView.setHeight(0)
//        }
////            holder.itemView.visibility = GONE
    }

    override fun getItemCount() = list.size - 1

    fun addItem(loveModel: LoveModel) {
        loveModel.let {
            list.add(0, it)
            notifyItemInserted(list.indexOf(loveModel))
        }
    }

    fun getItem(position: Int): LoveModel {
        return list[position]
    }

    fun getData(): ArrayList<LoveModel> {
        notifyDataSetChanged()
        return list
    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setList(list: ArrayList<LoveModel>) {
        this.list = list
        notifyDataSetChanged()

    }

    fun deleteItemsAndNotifyAdapter(pos: Int) {
        list.removeAt(pos)
        notifyItemRemoved(pos)
    }

    inner class HistoryViewHolder(private var binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.tvFirstName.text = loveModel.firstName
            binding.tvSecondName.text = loveModel.secondName
            var perc = loveModel.percentage
            binding.tvResult.text = loveModel.result

            binding.tvPercentage.text = "$perc%"

            itemView.setOnLongClickListener {
                onLongClickListener?.invoke(adapterPosition)
                return@setOnLongClickListener true
            }

        }

    }
}
