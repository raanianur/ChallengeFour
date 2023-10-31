package com.raniara.challengefour.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.raniara.challengefour.HomeFragmentDirections
import com.raniara.challengefour.databinding.ItemNoteBinding
import com.raniara.challengefour.room.DataNote


class NoteAdapter (
    val requireContext: Context,
    val listNote: List<DataNote>
): RecyclerView.Adapter<NoteAdapter.ViewHolder>()
{
    class ViewHolder(var binding : ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
        fun data(itemData : DataNote){
            binding.datanote = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listNote[position]
        holder.data(listNote[position])

        holder.binding.btnDelete.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDeleteNoteFragment(data)
            Navigation.findNavController(it).navigate(action)

        }

        holder.binding.btnEdit.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }
}