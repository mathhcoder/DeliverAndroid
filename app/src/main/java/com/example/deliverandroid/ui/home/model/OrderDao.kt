package com.example.deliverandroid.ui.home.model

import androidx.room.*
import io.reactivex.rxjava3.core.Single

@Dao
interface OrderDao {

    @Query("SELECT * FROM `order`")
    fun getAll(): Single<List<OrderEntity>>

    @Query("SELECT * FROM `order` WHERE id=:id")
    fun getAll(id: Long) : List<OrderEntity>

    @Query("DELETE FROM `order`")
    fun clear()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(data: List<OrderEntity>)

    @Transaction
    fun updateAll(data: List<OrderEntity>) {
        clear()
        addAll(data)
    }

}