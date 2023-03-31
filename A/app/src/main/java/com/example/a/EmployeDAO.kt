package com.example.a

import androidx.contentpager.content.Query
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeDAO {
    @Insert
    suspend fun insert(employeEntity: EmployeEntity)

    @Update
    suspend fun update(employeEntity: EmployeEntity)

    @Delete
    suspend fun delete(employeEntity: EmployeEntity)

    @androidx.room.Query(" SELECT * FROM 'employee-table'" )
    fun fetchAllUsers(): Flow<List<EmployeEntity>>

    @androidx.room.Query("SELECT * FROM 'employee-table' where id=:id")
    fun fetchUserById(id: Int): Flow<EmployeEntity>

}