/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.service

import com.vr.api.models.Person
import java.util.Optional
import org.springframework.stereotype.Service;
/*

  @author Vishal
  Created on 19 Aug, 2020
*/

@Service
interface PersonService {
    fun getUserById(userId: Int):Optional<Person?>
//    fun getAllUsers():List<Person>?
    fun findAllPerson():List<Person>?
}