package com.vr.api.daoImpl

import com.vr.api.utils.standerdDateTimeFormat
import java.sql.ResultSet
import java.sql.SQLException
import com.vr.api.utils.*
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import com.vr.api.dao.NoteDao
import com.vr.api.models.Notes
import javax.sql.DataSource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import com.vr.api.mappers.NoteMapper

/*
  @author altius
  Created on 6 Sep, 2020
*/

@Repository
class NoteDaoImpl : NoteDao {
    
    private lateinit var dataSource: DataSource
    private lateinit var jdbcTemplate: JdbcTemplate

    @Autowired
    fun setDataSource(dataSource: DataSource) {
        this.dataSource = dataSource
        this.jdbcTemplate = JdbcTemplate(dataSource)
    }

    override fun addNote(note: Notes): Int {
        try {
            val noteInsert: SimpleJdbcInsert = SimpleJdbcInsert(this.dataSource).withTableName("notes").usingGeneratedKeyColumns("id")
            val params = HashMap<String, Any?>()
            val curDate = standerdDateTimeFormat()
            params.put("note_title", note.title)
            params.put("note_desc", note.description)
            params.put("created_by", note.createBy)
            params.put("created_date", curDate)
            params.put("updated_by", note.updatedBy)
            params.put("updated_date", curDate)
            val i = noteInsert.executeAndReturnKey(params).toInt()
            println("Note Inserted Index: $i")
            return DATA_INSERT
        } catch(sql: SQLException) {
            println("Exc during note insertion: ${sql.message}")
            return SQL_ERROR
        }
    }

    override fun findNoteById(id: Int): Notes? {
        val sql = "SELECT * FROM notes n WHERE n.`id` = ?;"
        val rm: RowMapper<Notes> = RowMapper<Notes> {
            rs: ResultSet, i: Int ->
            Notes(rs.getInt("id"), rs.getString("note_title"), rs.getString("note_desc"), rs.getInt("created_by"), rs.getInt("updated_by"))
        }
        return this.jdbcTemplate.queryForObject(sql, arrayOf(id), rm)
    }
    
    override fun allNotes(): List<Notes> {
        val sql = "SELECT * FROM notes;"
        return this.jdbcTemplate.query(sql, NoteMapper())
    }
}