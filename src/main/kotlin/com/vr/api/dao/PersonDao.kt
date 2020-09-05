/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.dao
import com.vr.api.models.Person
/*

  @author altius
  Created on 19 Aug, 2020
*/

interface PersonDao {
    fun getUserById(userId: Int): Person?
    fun getAllUser(): List<Person>?
}