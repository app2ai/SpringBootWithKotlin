/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.models

/*
  @author Vishal
  Created on 20 Aug, 2020
*/
import javax.persistence.*;

@Entity
data class Person(
        @Id
        @GeneratedValue
        var id:Int = -1,
        var fname: String? = null,
        var lname: String? = null,
        var age: Int = 0)