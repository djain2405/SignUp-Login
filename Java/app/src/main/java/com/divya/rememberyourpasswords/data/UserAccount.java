package com.divya.rememberyourpasswords.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static com.divya.rememberyourpasswords.data.UserAccount.TABLE_NAME;

/**
 * Created by divya on 5/14/2018.
 */

@Entity(tableName = TABLE_NAME)
public class UserAccount {

    public static final String TABLE_NAME = "useraccounts";

    @PrimaryKey @NonNull
    String userId;
    String password;


    public UserAccount()
    {

    }
    public UserAccount(String username, String pwd)
    {
        this.userId = username;
        this.password = pwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
