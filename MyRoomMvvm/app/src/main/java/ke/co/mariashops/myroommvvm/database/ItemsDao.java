package ke.co.mariashops.myroommvvm.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ke.co.mariashops.myroommvvm.ItemsEntity;

@Dao
public interface ItemsDao
{
    @Insert
    void insert(ItemsEntity itemsEntity);
    @Update
    void update(ItemsEntity itemsEntity);

    @Delete
    void  delete(ItemsEntity itemsEntity);

    @Query("DELETE  FROM ItemsEntity")
    void  deleteAllItems();

    @Query("SELECT * FROM ItemsEntity")
    LiveData<List<ItemsEntity>>getData();
}
