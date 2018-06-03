package com.divya.rememberyourpasswords;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.divya.rememberyourpasswords.data.UserAccountDatabase;
import com.divya.rememberyourpasswords.data.UserRepository;

/**
 * Created by divya on 5/16/2018.
 */

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;

    public UserViewModel(Context context) {

        userRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao());
    }

    void createUser(String username, String password)
    {
        userRepository.insertUser(username, password);
    }

    boolean checkValidLogin(String username, String password)
    {
        return userRepository.isValidAccount(username, password);
    }

   public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new UserViewModel(ctxt));
        }
    }
}
