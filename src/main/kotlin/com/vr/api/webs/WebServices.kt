package com.vr.api.webs

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import com.vr.api.service.PersonService

@RestController
@RequestMapping("/v1/")
class WebServices {

//    companion object{     : ErrorController
//        private const val ERROR_PATH = "/error"
//    }

    @Autowired
    lateinit var personService: PersonService

//    override fun getErrorPath(): String? {
//        return ERROR_PATH
//    }

//    @RequestMapping(ERROR_PATH)    
//    fun error(): String { 
//        return "<h2>Facing error during execution of QUERY</h2>"
//    }
    
    @GetMapping("/")
    fun welcom(): String {
        println("================== Welcome API called")
        return "<h3>Kotlin APIs and Server started successfully</h3>"
    }

    @GetMapping("/user-info/{userId}")
    fun getUserInfo(@PathVariable userId: Int): String {
        print("Start api")
        var person = personService.getUserById(userId)
        return "Hello Mr. ${person ?: "Anoy"}"
        print("End api")
    }
}