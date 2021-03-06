package com.example.gd_bean_ui.convert;

import com.example.gd_bean_ui.vo.MenuInfo;
import com.example.gd_bean_ui.vo.ncVo.NcMenu;

/**
 *  @Description :
 *  @autho : dongyiming
 *  @version : 1.0
 *  @data : 2017/7/11 17:54
 */
public class MenuInfoConvert implements IBaseConvert<NcMenu,MenuInfo>{

    @Override
    public MenuInfo convert(NcMenu ncMenu) {

        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setAuthorCode(ncMenu.getAuthorCode());
        menuInfo.setAuthorName(ncMenu.getAuthorName());
        menuInfo.setMenuCode(ncMenu.getMenuCode());
        menuInfo.setMenuName(ncMenu.getMenuName());
        menuInfo.setMenuDesc(ncMenu.getMenuDesc());
        menuInfo.setCreateTime(ncMenu.getCreateTime());
        menuInfo.setUpdateTime(ncMenu.getUpdateTime());
        if (ncMenu.getMenuPicurl() != null) {
            menuInfo.setMenuPicurl(ncMenu.getMenuPicurl());
        }
        menuInfo.setPlaycount(ncMenu.getPlaycount());
        menuInfo.setMenuType(ncMenu.getMenuType());
        return menuInfo;
    }
}
