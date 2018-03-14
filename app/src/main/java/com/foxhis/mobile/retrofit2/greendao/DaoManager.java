package com.foxhis.mobile.retrofit2.greendao;

import android.database.sqlite.SQLiteDatabase;

import com.foxhis.mobile.retrofit2.app.MyApplication;

/**
 * Created by zyh on 2017/12/26.
 */

public class DaoManager {
    private static DaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public DaoManager() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), "my-db", null);
        SQLiteDatabase wd = devOpenHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(wd);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public static DaoManager getInstance() {
        if (mInstance == null) {
            mInstance = new DaoManager();
        }
        return mInstance;
    }
}
