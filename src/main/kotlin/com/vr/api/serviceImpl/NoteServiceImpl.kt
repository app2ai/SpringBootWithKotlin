package com.vr.api.serviceImpl

import com.vr.api.service.NoteService
import org.springframework.stereotype.Service
import com.vr.api.dao.NoteDao
import com.vr.api.models.Notes
import org.springframework.beans.factory.annotation.Autowired

/*

  @author Vishal
  Created on 6 Sep, 2020
*/

@Service
class NoteServiceImpl : NoteService {
    
    @Autowired
    lateinit var noteDao: NoteDao

    override fun addNotes(notes: Notes): Int {
        return noteDao.addNote(notes)
    }

    override fun findNoteById(id: Int): Notes? {
        return noteDao.findNoteById(id)
    }

    override fun allNotes(): List<Notes> {
        return noteDao.allNotes()
    }
}