package com.vr.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class ApiApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
           runApplication<ApiApplication>(*args)
}
