package com.vr.api.models

import com.fasterxml.jackson.annotation.JsonCreator
/*
  @author Vishal
  Created on 6 Sep, 2020
*/
data class Notes @JsonCreator constructor(
    var id: Int? = null,
    var title: String,
    var description: String,
    var createBy: Int,
    var updatedBy: Int,
    var createdDate: String = "",
    var updateDate: String = ""
)