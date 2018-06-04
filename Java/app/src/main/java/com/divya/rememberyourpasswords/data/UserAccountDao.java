package com.divya.rememberyourpasswords.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.divya.rememberyourpasswords.data.UserAccount;

/**
 * Created by divya on 5/14/2018.
 */

@Dao
public interface UserAccountDao {

    @Insert
    void insert(UserAccount account);

    @Query("SELECT * FROM useraccounts WHERE useraccounts.userId LIKE :username")
    UserAccount getAccount(String username);
}
