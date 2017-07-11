package com.example.gd_normal_ui.repository;

import android.database.SQLException;
import android.util.Log;

import com.example.gd_bean_ui.greendao.DaoSession;
import com.example.gd_normal_ui.manager.DaoSessionEngine;

import java.util.List;

/**
 * @version : 1.0
 * @Description : 数据库操作基类
 * @autho : dongyiming
 * @data : 2017/7/10 23:39
 */
public class BaseRepository<T> {

    public final DaoSession readableSession;
    public final DaoSession writeableSession;

    public BaseRepository() {
        readableSession = DaoSessionEngine.getInstance().getReadableSession();
        writeableSession = DaoSessionEngine.getInstance().getWriteableSession();
    }

    /**
     * 插入一条数据
     *
     * @param t
     * @return
     */
    public boolean insertItem(T t) {

        boolean flag;
        try {
            flag = writeableSession.insert(t) != -1 ? true : false;
        } catch (Exception e) {
            throw new SQLException("insert item failed");
        }
        return flag;
    }

    /**
     * 更新一条数据
     *
     * @param t
     */
    public void updateItem(T t) {

        try {
            writeableSession.update(t);
        } catch (Exception e) {
            Log.e("dongyiming", "updateItem failed");
        }
    }

    /**
     * 更新多条数据
     *
     * @param t
     * @param clss
     */
    public void updateList(final List<T> t, Class clss) {

        if (t == null || t.isEmpty()) {
            Log.e("dongyiming", "updateList is failed");
            return;
        }

        try {
            writeableSession.getDao(clss).updateInTx(new Runnable() {
                @Override
                public void run() {
                    for (T item : t) {
                        writeableSession.update(item);
                    }
                }
            });
        } catch (Exception e) {
            Log.e("dongyiming", "updateItem failed and exception is : " + e.toString());
        }
    }

    /**
     * 删除所有数据
     *
     * @param clss
     * @return
     */
    public boolean deleteAll(Class clss) {

        boolean flag;
        try {
            writeableSession.deleteAll(clss);
            flag = true;
        } catch (Exception e) {
            Log.e("dongyiming", e.toString());
            flag = false;
        }
        return flag;
    }

    /**
     * 删除一条数据
     *
     * @param t
     * @return
     */
    public void deleteObject(T t) {

        try {
            writeableSession.delete(t);
        } catch (Exception e) {
            Log.e("dongyiming", e.toString());
        }
    }

    /**
     * 删除多条数据
     *
     * @param t
     * @return
     */
    public boolean deleteList(final List<T> t, Class clss) {

        boolean flag;

        if (null == t || t.isEmpty()) {
            return false;
        }

        try {

            writeableSession.getDao(clss).deleteInTx(new Runnable() {
                @Override
                public void run() {
                    for (T item : t) {
                        writeableSession.delete(item);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            Log.e("dongyiming", e.toString());
            flag = false;
        }
        return flag;
    }


    /**
     * 根据主键ID来查询
     *
     * @param id
     * @return
     */
    public T QueryById(int id, Class clss) {
        return (T) readableSession.getDao(clss).loadByRowId(id);
    }

    /**
     * 查询某条件下的对象
     *
     * @param clss
     * @return
     */
    public List<T> QueryList(Class clss, String where, String... params) {
        Object obj = null;
        List<T> objects = null;
        try {
            obj = readableSession.getDao(clss);
            if (null == obj) {
                return null;
            }
            objects = readableSession.getDao(clss).queryRaw(where, params);
        } catch (Exception e) {
            Log.e("dongyiming", e.toString());
        }

        return objects;
    }

    /**
     * 查询所有对象
     *
     * @param clss
     * @return
     */
    public List<T> QueryAll(Class clss) {
        List<T> objects = null;
        try {
            objects = (List<T>) readableSession.getDao(clss).loadAll();
        } catch (Exception e) {
            Log.e("dongyiming", e.toString());
        }
        return objects;
    }
}
