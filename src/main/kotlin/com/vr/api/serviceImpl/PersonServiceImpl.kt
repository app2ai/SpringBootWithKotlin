/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.serviceImpl

import org.springframework.stereotype.Service;
import com.vr.api.service.PersonService
import com.vr.api.dao.PersonDao
import com.vr.api.models.Person
import org.springframework.beans.factory.annotation.Autowired

/*
  @author altius
  Created on 19 Aug, 2020
*/

@Service
class PersonServiceImpl : PersonService {
    
    @Autowired
    lateinit var personDao: PersonDao

    override fun getUserById(userId: Int): Person? {
        return personDao.getUserById(userId)
    }
    
    override fun getAllUsers(): List<Person>? {
        return personDao.getAllUser()
    }
}