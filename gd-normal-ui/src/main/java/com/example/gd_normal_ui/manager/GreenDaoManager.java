package com.example.gd_normal_ui.manager;

import android.content.Context;
import android.util.Log;

import com.example.gd_bean_ui.vo.MenuInfo;
import com.example.gd_normal_ui.interaction.IGreenDaoManager;
import com.example.gd_normal_ui.interaction.IMenuRepository;
import com.example.gd_normal_ui.repository.MenuRepository;
import com.example.gd_rxjava_retrofit.cache.RetrofitBuilder;

import java.util.List;

import rx.Subscriber;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/11 10:51
 */
public class GreenDaoManager implements IGreenDaoManager {

    private final RetrofitBuilder retrofitBuilder;

    private Context mContext;
    private final IMenuRepository menuRepository;

    public GreenDaoManager(Context mContext) {

        this.mContext = mContext;
        retrofitBuilder = RetrofitBuilder.getInstance();
        menuRepository = new MenuRepository();
    }

    @Override
    public void getAllMenuInfo() {

        retrofitBuilder.getAll(new Subscriber<List<MenuInfo>>() {
            @Override
            public void onCompleted() {

                Log.e("dongyiming", "retrofit load completed");
            }

            @Override
            public void onError(Throwable e) {

                Log.e("dongyiming", "retrofit getAll() is failed :" + e.toString());
            }

            @Override
            public void onNext(List<MenuInfo> menuInfos) {

                menuRepository.insertList(menuInfos);
            }
        });
    }

    public void insertOne() {

        MenuInfo menuInfo = new MenuInfo();
    }

    public void deleteOne() {

    }

    public void updateOne() {

    }

    public void selectOne() {

    }

}
