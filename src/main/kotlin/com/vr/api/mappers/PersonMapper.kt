/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.mappers

import com.vr.api.models.Person
import java.sql.ResultSet
import org.springframework.jdbc.core.RowMapper

/*
  @author Vishal
  Created on 21 Aug, 2020
*/

class PersonMapper : RowMapper<Person> {
    
    override fun mapRow(rs: ResultSet, i: Int): Person {
        return Person(
            rs.getInt("id"),
            rs.getString("fname"),
            rs.getString("lname"),
            rs.getInt("age")                      
        )
    }
}