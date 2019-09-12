package com.thetechnocafe.Room.bottomsheets.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.thetechnocafe.Room.bottomsheets.model.ItemsEntity;

import java.util.List;

@Dao
public interface ItemsDao
{
    @Query("SELECT * FROM ItemsEntity")
    List<ItemsEntity> getData();

    @Insert
    void insertAll(ItemsEntity... itemsEntities);


}
