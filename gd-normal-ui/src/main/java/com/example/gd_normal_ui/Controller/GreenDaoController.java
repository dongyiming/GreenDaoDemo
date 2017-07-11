package com.example.gd_normal_ui.Controller;

import android.content.Context;

import com.example.gd_normal_ui.interaction.IGreenDaoManager;
import com.example.gd_normal_ui.manager.GreenDaoManager;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/10 21:03
 */
public class GreenDaoController {

    private Context mContext;
    private final IGreenDaoManager iGreenDaoManager;

    public GreenDaoController(Context mContext) {

        this.mContext = mContext;
        iGreenDaoManager = new GreenDaoManager(mContext);
    }

    public void getAllMenuInfo() {
        iGreenDaoManager.getAllMenuInfo();
    }

}
