package com.example.gd_normal_ui.repository;

import android.util.Log;

import com.example.gd_bean_ui.greendao.MenuInfoDao;
import com.example.gd_bean_ui.vo.MenuInfo;
import com.example.gd_normal_ui.interaction.IMenuRepository;

import java.util.List;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/10 21:13
 */
public class MenuRepository extends BaseRepository<MenuInfo> implements IMenuRepository {

    private MenuInfoDao menuInfoDao;

    public MenuRepository() {

        menuInfoDao = readableSession.getMenuInfoDao();
    }

    /**
     * 添加
     *
     * @param menuInfo
     */
    @Override
    public void addOrUpdate(MenuInfo menuInfo) {

        MenuInfo menu = selectById(menuInfo.getMenuCode());
        if (menu != null) {
            updateItem(menuInfo);
        } else {
            insertItem(menuInfo);
        }
    }

    @Override
    public void insert(MenuInfo menuInfo) {
        insertItem(menuInfo);
    }

    /**
     * 插入多条数据
     *
     * @param menuInfos
     * @return
     */
    @Override
    public boolean insertList(final List<MenuInfo> menuInfos) {

        boolean flag;
        if (menuInfos == null || menuInfos.isEmpty()) {
            Log.e("dongyiming", "insertList is failed");
            return false;
        }
        try {
            writeableSession.getMenuInfoDao().insertInTx(menuInfos);
            flag = true;
        } catch (Exception e) {
            flag = false;
            Log.e("dongyiming", "insertList failed and exception is : " + e.toString());
        }
        return flag;
    }

    @Override
    public MenuInfo selectById(int menuInfoCode) {

        MenuInfo menuInfo = menuInfoDao.queryBuilder().where(MenuInfoDao.Properties.MenuCode.eq(menuInfoCode)).build().unique();
        return menuInfo;
    }

}
