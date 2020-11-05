package com.vr.api.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository;
import com.vr.api.models.Person
/*
  @author Vishal
  Created on 5 Nov, 2020
*/
@Repository
public interface PersonRepo: JpaRepository<Person, Int>