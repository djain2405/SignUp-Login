package com.divya.rememberyourpasswords.data.Db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.divya.rememberyourpasswords.data.Dao.UserAccountDao;
import com.divya.rememberyourpasswords.data.Entity.UserAccount;

/**
 * Created by divya on 5/14/2018.
 */

@Database(entities = {UserAccount.class}, version = 1)
public abstract class UserAccountDatabase extends RoomDatabase{

    public abstract UserAccountDao userAccountDao();
    public static UserAccountDatabase INSTANCE;

    public static UserAccountDatabase getAppDatabase(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserAccountDatabase.class, "user-database").build();

        }

        return INSTANCE;

    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }

}
