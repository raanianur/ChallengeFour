package com.raniara.challengefour.repository

import androidx.lifecycle.LiveData
import com.raniara.challengefour.room.DataNote
import com.raniara.challengefour.room.NoteDAO


class AppRepository (val dao : NoteDAO){
    fun getAllNote(): LiveData<List<DataNote>> {
        return dao.getDataNote()
    }
    fun insertNote(note : DataNote){
        dao.insertNote(note)
    }
    fun deleteNote(id : Int){
        dao.deleteNote(id)
    }
    fun updateNote(note : DataNote){
        dao.updateNote(note)
    }

}