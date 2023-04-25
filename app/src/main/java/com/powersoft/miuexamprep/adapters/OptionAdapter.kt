package com.powersoft.miuexamprep.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.databinding.ItemOptionBinding
import com.powersoft.miuexamprep.view_models.McqViewModel

class OptionAdapter(val listAnswer: List<String>, private val viewModel: McqViewModel) :
    RecyclerView.Adapter<OptionAdapter.Holder>() {
    private var prevSelectedIndex = -1
    private val charArr = charArrayOf('A', 'B', 'C', 'D', 'E', 'F')

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(ItemOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, pos: Int) {
        holder.bind(pos)

        if (pos == prevSelectedIndex) {
            holder.b.rootView.strokeWidth = 6
            holder.b.rootView.strokeColor =
                ContextCompat.getColor(holder.itemView.context, R.color.app_blue)
        } else {
            holder.b.rootView.strokeWidth = 0
        }
    }

    override fun getItemCount() = listAnswer.size

    inner class Holder(val b: ItemOptionBinding) : RecyclerView.ViewHolder(b.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun bind(pos: Int) {
            b.tvNumber.text = charArr[pos].toString()
            b.tvOption.text = listAnswer[pos]
            b.rootView.setOnClickListener {
                prevSelectedIndex = pos
                notifyDataSetChanged()
                viewModel.updateQuestion(listAnswer[pos])
            }
        }
    }
}