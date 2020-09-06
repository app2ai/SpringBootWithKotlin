/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/*

  @author Vishal
  Created on 7 Sep, 2020
*/

fun standerdDateTimeFormat():String{
    val local = LocalDateTime.now()
    val formmator = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return local.format(formmator)
}