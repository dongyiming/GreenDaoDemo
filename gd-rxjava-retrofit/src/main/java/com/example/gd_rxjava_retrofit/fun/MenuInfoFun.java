package com.example.gd_rxjava_retrofit.fun;

import com.example.gd_bean_ui.convert.MenuInfoConvert;
import com.example.gd_bean_ui.vo.MenuInfo;
import com.example.gd_bean_ui.vo.ncVo.NcMenu;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/11 17:41
 */
public class MenuInfoFun implements Func1<List<NcMenu>, List<MenuInfo>> {

    @Override
    public List<MenuInfo> call(List<NcMenu> ncMenus) {

        List<MenuInfo> menuInfos = new ArrayList<>();
        if (ncMenus != null && ncMenus.size() != 0) {
            MenuInfoConvert menuInfoConvert = new MenuInfoConvert();
            for (NcMenu ncMenu : ncMenus) {
                MenuInfo menuInfo = menuInfoConvert.convert(ncMenu);
                menuInfos.add(menuInfo);
            }
        }
        return menuInfos;
    }
}
