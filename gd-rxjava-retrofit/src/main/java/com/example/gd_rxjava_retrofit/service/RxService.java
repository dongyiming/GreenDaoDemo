package com.example.gd_rxjava_retrofit.service;


import com.example.gd_bean_ui.vo.ncVo.NcMenu;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @version : 1.0
 * @Description : 本地服务器数据目前未作结果封装，返回原始数据,后面有时间服务器再做修改
 * @autho : dongyiming
 * @data : 2017/7/8 18:05
 */
public interface RxService {


    @GET("getAll")
    public Observable<List<NcMenu>> getAll();

    @POST("addMenu")
    public Observable<String> insertOne();
}
