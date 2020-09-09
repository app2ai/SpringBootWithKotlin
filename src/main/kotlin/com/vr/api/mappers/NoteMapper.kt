/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.mappers

import com.vr.api.models.Notes
import java.sql.ResultSet
import org.springframework.jdbc.core.RowMapper

/*

  @author Visha;
  Created on 9 Sep, 2020
*/

class NoteMapper : RowMapper<Notes>{
    override fun mapRow(rs: ResultSet, i: Int): Notes {
        return Notes(
            rs.getInt("id"),
            rs.getString("note_title"),
            rs.getString("note_desc"),
            rs.getInt("created_by"),
            rs.getInt("updated_by"),
            rs.getString("created_date"),
            rs.getString("updated_date")                      
        )
    }
}