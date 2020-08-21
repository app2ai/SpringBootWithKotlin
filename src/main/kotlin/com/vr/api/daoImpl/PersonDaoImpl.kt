/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api.daoImpl

import java.sql.ResultSet
import java.sql.SQLException
import javax.sql.DataSource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository;
import com.vr.api.dao.PersonDao
import com.vr.api.models.Person
import org.springframework.beans.factory.annotation.Autowired


@Repository
class PersonDaoImpl : PersonDao {
    
    private lateinit var dataSource: DataSource
    private lateinit var jdbcTemplate: JdbcTemplate
    
    @Autowired
    fun setDataSource(dataSource: DataSource){
        this.dataSource = dataSource
        this.jdbcTemplate = JdbcTemplate(dataSource)
    }
    
    @Throws(SQLException::class)
    override fun getUserById(userId: Int): Person? {
        val personQuery = "SELECT * FROM person p WHERE p.`id` = ?"
        val rm: RowMapper<Person?> = RowMapper<Person?>{
            rs: ResultSet, i: Int->
            Person(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getInt("age"))
        }
        return this.jdbcTemplate.queryForObject(personQuery, arrayOf(userId), rm)
    }
}