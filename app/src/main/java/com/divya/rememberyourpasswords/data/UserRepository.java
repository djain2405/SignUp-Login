package com.divya.rememberyourpasswords.data;

import android.arch.lifecycle.LiveData;

import com.divya.rememberyourpasswords.data.Dao.UserAccountDao;
import com.divya.rememberyourpasswords.data.Entity.UserAccount;

/**
 * Created by divya on 5/16/2018.
 */

public class UserRepository {

    private final UserAccountDao userAccountDao;
    private static UserRepository instance;

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

    public boolean isValidAccount(String username, String password)
    {
        LiveData<UserAccount> userAccountLiveData = userAccountDao.getAccount(username);
        return userAccountLiveData.getValue().getPassword().equals(password);

    }

    public void insertUser(String username, String password)
    {
        userAccountDao.insert(new UserAccount(username, password));
    }
}
