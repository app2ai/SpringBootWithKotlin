package com.vr.api.webs

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import com.vr.api.service.PersonService
import com.vr.api.service.NoteService
import com.vr.api.models.RestResponse
import com.vr.api.models.Notes
import com.vr.api.utils.*

@RestController
@RequestMapping("/v1")
class WebServices : ErrorController{

    // SWAGGER URL: http://localhost:8085/swagger-ui.html
    companion object{
        private const val ERROR_PATH = "/error"
    }

    @Autowired
    lateinit var personService: PersonService
    
    @Autowired
    lateinit var noteService: NoteService

    override fun getErrorPath(): String? {
        return ERROR_PATH
    }

    @RequestMapping(ERROR_PATH)    
    fun error(): String { 
        return "<h4>Facing error during execution of QUERY</h4>"
    }
    
    @GetMapping("/")
    fun welcom(): String {
        return "<h3>Kotlin APIs and Server started successfully</h3>"
    }

    @GetMapping("/user-info/{userId}")
    fun getUserInfo(@PathVariable userId: Int): String {
        var person = personService.getUserById(userId)
        return "Hello Mr. ${person ?: "Anoy"}"
    }
    
    @GetMapping("/all-user")
    fun getAllUser():String{
        val personList = personService.getAllUsers()
        personList?.forEach { 
            println(it.fname)
        }
        return "Total users are ${personList?.size}"
    }
    
    @PostMapping(path = arrayOf("/add-note"))
    fun addNote(@RequestBody note: Notes):RestResponse?{
        println("Add note method entered")
        val result = noteService.addNotes(note)
        return when(result){
            DATA_INSERT -> RestResponse(SUCCESS, "Note added successfully.", null)
            SQL_ERROR -> RestResponse(FAILED, "Oops, Note doesn't added successfully", null)
            else -> RestResponse(FAILED, UNKNOWN_ERROR_DESC, null)
        }
    }
    
    @GetMapping("/note/{id}")
    fun getNoteById(@PathVariable id: Int):Notes?{
        return noteService.findNoteById(id)
    }
}