package com.raniara.challengefour

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.raniara.challengefour.databinding.FragmentEditNoteBinding
import com.raniara.challengefour.room.DataNote
import com.raniara.challengefour.viewmodel.NoteViewModel


class EditNoteFragment : Fragment() {

    lateinit var binding: FragmentEditNoteBinding
    val viewModel: NoteViewModel by viewModels()
    val args: EditNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditNoteBinding.inflate(layoutInflater,container,false)
        binding.etId.setText(args.datanote.id.toString())
        binding.etJudul.setText(args.datanote.title.toString())
        binding.etContent.setText(args.datanote.content.toString())

        binding.btnUpdate.setOnClickListener{
            updateNote(it)
        }
        return binding.root
    }
    private fun updateNote(it: View?) {
        var judul = binding.etJudul.text.toString()
        var isi = binding.etContent.text.toString()

        val data = DataNote(args.datanote.id, judul, isi)
        viewModel.updateNote(data)

        findNavController().navigate(R.id.action_editNoteFragment_to_homeFragment)

    }

}



//override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//    //inflate the layout for this fragment
//
//    binding = FragmentEditNoteBinding.inflate(layoutInflater)
//
//    binding.etId.setText(args.datanote.id.toString())
//    binding.etJudul.setText(args.datanote.title.toString())
//    binding.etContent.setText(args.datanote.content.toString())
//
//    binding.btnUpdate.setOnClickListener {
//        updateNote()
//    }
//    return AlertDialog.Builder(requireActivity())
//        .setView(binding.root)
//        .create()
//
//
//}
//
//private fun updateNote() {
//    var judul = binding.etJudul.text.toString()
//    var isi = binding.etContent.text.toString()
//
//    val data = DataNote(args.datanote.id, judul, isi)
//    viewModel.updateNote(data)
//
//    dismiss()
//}