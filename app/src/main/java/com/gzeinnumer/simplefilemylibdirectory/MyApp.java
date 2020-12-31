package com.gzeinnumer.simplefilemylibdirectory;

import android.app.Application;

import com.gzeinnumer.gzndirectory.helper.FGDir;

//todo 9 make class MyApp
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //todo 10 Declare your folder external name
        String externalFolderName = getApplicationContext().getString(R.string.app_name); //MyLibsTesting
        FGDir.initExternalDirectoryName(externalFolderName);
    }
}