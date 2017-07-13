package com.example.gd_normal_ui.manager;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gd_bean_ui.greendao.DaoMaster;
import com.example.gd_bean_ui.greendao.DaoSession;
import com.example.gd_normal_ui.utils.FileUtils;

import java.io.File;

/**
 * @version : 1.0
 * @Description : 数据库本地存储
 * @autho : dongyiming
 * @data : 2017/7/13 0:26
 */
public class DaoHelperEngine {

    private static DaoHelperEngine mInstance;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private final static String DB_PATH = "NcCat/nc/dongyiming/database";
    private final static String DB_NAME = "nc.db";

    private DaoHelperEngine() {
    }

    public static DaoHelperEngine getInstance() {

        if (mInstance == null) {
            synchronized (DaoSessionEngine.class) {
                if (mInstance == null) {
                    mInstance = new DaoHelperEngine();
                }
            }
        }
        return mInstance;
    }

    /**
     * 设置数据库外部存储
     *
     * @param mContext
     * @return
     */
    public DaoMaster getDaoMaster(Context mContext) {

        if (daoMaster == null) {

            try {
                //Context的包装类，重写数据库操作
                DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(new ContextWrapper(mContext) {
                    @Override
                    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
                        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
                    }

                    @Override
                    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
                        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
                    }

                    @Override
                    public File getDatabasePath(String name) {
                        File file = FileUtils.buildDataBasePath(DB_PATH, name);
                        return file != null ? file : super.getDatabasePath(name);
                    }

                }, DB_NAME, null);

                daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            } catch (Exception e) {
                Log.e("dongyiming", "create daomaster failed :" + e.toString());
                e.printStackTrace();
            }
        }
        return daoMaster;
    }

    /**
     * @param mContext
     * @return
     */
    public DaoSession getDaoSession(Context mContext) {

        if (daoSession == null) {

            if (daoMaster == null) {
                daoMaster = getDaoMaster(mContext);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
