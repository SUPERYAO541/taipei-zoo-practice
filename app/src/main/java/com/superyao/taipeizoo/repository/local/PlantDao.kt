package com.superyao.taipeizoo.repository.local

import androidx.room.*
import com.superyao.taipeizoo.model.Plant

@Dao
abstract class PlantDao {
    @Query("SELECT COUNT(id) FROM plant")
    abstract fun getSize(): Int

    @Query("SELECT * FROM plant WHERE (fLocation LIKE :pavilionName AND id < (:limit + 1) + :offset AND id > :offset)")
    abstract fun getPlants(pavilionName: String, limit: Int, offset: Int): List<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg plant: Plant): LongArray

    @Update
    abstract fun update(vararg plant: Plant): Int

    @Delete
    abstract fun delete(vararg plant: Plant): Int
}