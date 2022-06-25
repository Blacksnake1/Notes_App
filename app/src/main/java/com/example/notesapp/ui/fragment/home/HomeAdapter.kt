package com.example.notesapp.ui.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.databinding.ItemNoteBinding
import com.example.notesapp.model.NotesModel

class HomeAdapter(
    var context: Context,
    var noteList: MutableList<NotesModel>,
    var onClickItem: (item: NotesModel) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =  ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = noteList[position]

        holder.binding.tvItemTitle.text = data.title
        holder.binding.tvItemSubtitle.text = data.subtitle
        holder.binding.tvItemContent.text = data.note
        holder.binding.tvItemDate.text = data.date
        holder.itemView.setOnClickListener {
            onClickItem.invoke(data)
        }
        when (data.priority) {
            "1" -> {
                holder.binding.imgItemPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2" -> {
                holder.binding.imgItemPriority.setBackgroundResource(R.drawable.red_dot)
            }
            "3" -> {
                holder.binding.imgItemPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
        }

    }

    override fun getItemCount(): Int = noteList.size

}