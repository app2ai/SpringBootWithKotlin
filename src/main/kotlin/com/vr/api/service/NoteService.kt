package com.vr.api.service

import com.vr.api.models.Notes
/*
  @author Vishal
  Created on 6 Sep, 2020
*/

interface NoteService {
    fun addNotes(notes: Notes):Int
    fun findNoteById(id: Int):Notes?
    fun allNotes():List<Notes>
}