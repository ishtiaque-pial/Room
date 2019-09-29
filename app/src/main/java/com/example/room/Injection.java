package com.example.room;

import android.content.Context;

import com.example.room.persistence.LocalUserDataSource;
import com.example.room.persistence.UsersDatabase;
import com.example.room.ui.ViewModelFactory;

public class Injection {
    public static UserDataSource provideUserDataSource(Context context) {
        UsersDatabase database = UsersDatabase.getInstance(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}