package com.example.gd_normal_ui.interaction;

import com.example.gd_bean_ui.vo.MenuInfo;

import java.util.List;

/**
 *  @Description :
 *  @autho : dongyiming
 *  @version : 1.0
 *  @data : 2017/7/11 11:50
 */
public interface IMenuRepository {
    void addOrUpdate(MenuInfo menuInfo);

    void insert(MenuInfo menuInfo);

    boolean insertList(List<MenuInfo> menuInfos);

    MenuInfo selectById(int menuInfoCode);
}
