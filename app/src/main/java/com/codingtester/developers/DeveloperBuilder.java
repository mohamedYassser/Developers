package com.codingtester.developers;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Developer.class, version = 1)
public abstract class DeveloperBuilder extends RoomDatabase {

    private static DeveloperBuilder dbInstance;

    public abstract DeveloperDao developerDao();

    public static synchronized DeveloperBuilder getInstance(Context context) {
        if(dbInstance == null) {
            dbInstance = Room.databaseBuilder(context.getApplicationContext(),
                    DeveloperBuilder.class, "DBDev")
                    .build();
        }
        return dbInstance;
    }

}
