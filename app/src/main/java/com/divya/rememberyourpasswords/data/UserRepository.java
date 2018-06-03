package com.divya.rememberyourpasswords.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

/**
 * Created by divya on 5/16/2018.
 */

public class UserRepository {

    private final UserAccountDao userAccountDao;
    private static UserRepository instance;
    private LiveData<UserAccount> userAccountLiveData;

    private UserRepository(UserAccountDao userAccountDao)
    {
        this.userAccountDao = userAccountDao;
    }

    public static UserRepository getInstance(UserAccountDao userAccountDao)
    {
        if(instance == null)
        {
            instance = new UserRepository(userAccountDao);
        }
        return instance;
    }

    public boolean isValidAccount(String username, final String password)
    {

        UserAccount userAccount = userAccountDao.getAccount(username);
        return userAccount.getPassword().equals(password);
    }

    public void insertUser(String username, String password)
    {
        UserAccount account = new UserAccount(username, password);
        userAccountDao.insert(account);
    }
}
