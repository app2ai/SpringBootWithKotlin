package com.vr.api.models

import com.google.gson.JsonElement

/*
  @author Vishal
  Created on 6 Sep, 2020
*/

class RestResponse(
    val status: String,
    val message: String,    
    val response: Any?
)