package com.raniara.challengefour.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.raniara.challengefour.repository.AppRepository
import com.raniara.challengefour.room.DataNote
import com.raniara.challengefour.room.NoteDatabase

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val repository : AppRepository

    init {
        val dao = NoteDatabase.getInstance(application)!!.noteDao()
        repository = AppRepository(dao)
    }

    fun addNote(note : DataNote){
        repository.insertNote(note)
    }
    fun getNote(): LiveData<List<DataNote>> = repository.getAllNote()

    fun deleteNote(id : Int){
        repository.deleteNote(id)
    }
    fun updateNote(note : DataNote){
        repository.updateNote(note)
    }
}