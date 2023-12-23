package com.example.lovecalculate.board

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculate52_2.Prefs
import com.example.lovecalculate52_2.R
import com.example.lovecalculate52_2.databinding.ItemBoardBinding

class BoardAdapter(val context: Context, val navController: NavController) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {


    private val text = arrayListOf(
        "Тебе одиноко?",
        "Тебе грустно?",
        "В этом приложении ты сможешь подсчитать совместимость",
        "И найти себе идеальну пару"
    )
    private val ImageView= arrayListOf(
        R.raw.lottie_alone,
        R.raw.lottie_sad,
        R.raw.lottie_love_slots,
        R.raw.lottie_love
    )




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = 4


    inner class BoardViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvText.text = text[position]
            binding.imageView.setAnimation(ImageView[position])
        }
    }
}






