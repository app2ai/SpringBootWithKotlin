/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.dao

import com.vr.api.models.Notes
/*

  @author altius
  Created on 6 Sep, 2020
*/

interface NoteDao {
    fun addNote(note: Notes):Int
    fun findNoteById(id: Int):Notes?
    fun allNotes():List<Notes>
}