package com.codingtester.developers;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DeveloperDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addDeveloper(Developer developer);

    @Query("select * from dev_table where title = :title")
    List<Developer> getDevelopersByTitle(String title);

    @Query("delete from dev_table where id = :id")
    void deleteDevByID(int id);

}
