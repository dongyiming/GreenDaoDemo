package com.example.gd_normal_ui.manager;

import android.util.Log;

import com.example.gd_bean_ui.greendao.DaoMaster;
import com.example.gd_bean_ui.greendao.DaoSession;
import com.example.gd_normal_ui.application.MyApplication;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/10 1:15
 */
public class DaoSessionEngine {

    private static DaoSessionEngine mInstance;

    private final String DB_NAME = "nc_db";
    private DaoMaster.DevOpenHelper devOpenHelper;

    private DaoSessionEngine() {

        Log.e("dongyiming", "constructor");
    }

    public static DaoSessionEngine getInstance() {

        Log.e("dongyiming", "static getInstance");
        if (mInstance == null) {
            synchronized (DaoSessionEngine.class) {
                if (mInstance == null) {
                    mInstance = new DaoSessionEngine();
                }
            }
        }
        return mInstance;
    }

    private DaoMaster.DevOpenHelper getOpenHelper() {

        if (devOpenHelper == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), DB_NAME, null);
        }
        return devOpenHelper;
    }

    public DaoSession getWriteableSession() {

        DaoMaster.DevOpenHelper openHelper = getOpenHelper();
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        return daoMaster.newSession();
    }

    public DaoSession getReadableSession() {

        DaoMaster.DevOpenHelper openHelper = getOpenHelper();
        DaoMaster daoMaster = new DaoMaster(openHelper.getReadableDatabase());
        return daoMaster.newSession();
    }
}
