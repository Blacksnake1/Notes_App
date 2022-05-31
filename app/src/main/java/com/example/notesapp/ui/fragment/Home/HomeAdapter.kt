package com.example.notesapp.ui.fragment.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentCreatNotesBinding
import com.example.notesapp.databinding.ItemNoteBinding
import com.example.notesapp.model.NotesModel

class HomeAdapter(
    var context: Context,
    var noteList: MutableList<NotesModel>,
    var onClickItem: (item: NotesModel) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = noteList[position]
        holder.binding.tvItemTitle.text = data?.title
        holder.binding.tvItemSubtitle.text = data?.subtitle
        holder.binding.tvItemContent.text = data?.note
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