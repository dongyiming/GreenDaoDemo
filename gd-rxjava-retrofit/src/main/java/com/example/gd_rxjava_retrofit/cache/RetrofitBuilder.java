package com.example.gd_rxjava_retrofit.cache;

import com.example.gd_bean_ui.vo.MenuInfo;
import com.example.gd_rxjava_retrofit.fun.MenuInfoFun;
import com.example.gd_rxjava_retrofit.service.RxService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @version : 1.0
 * @Description : 构建retrofit
 * @autho : dongyiming
 * @data : 2017/7/8 21:22
 */
public class RetrofitBuilder {


    private static final int DEFAULT_TIMEOUT = 5;
    public static final String BASE_URL = "http://192.168.1.101:8080/menu/";

    private Retrofit retrofit;
    private final RxService rxService;
    private static RetrofitBuilder instance;

    private RetrofitBuilder() {

        OkHttpClient.Builder httpclentBuilder = new OkHttpClient.Builder();
        httpclentBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(httpclentBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        rxService = retrofit.create(RxService.class);
    }

    public static RetrofitBuilder getInstance() {

        if (instance == null) {
            synchronized (RetrofitBuilder.class) {
                if (instance == null) {
                    instance = new RetrofitBuilder();
                }
            }
        }
        return instance;
    }

    /**
     * 获取所有数据
     *
     * @param subscriber
     */
    public void getAll(Subscriber<List<MenuInfo>> subscriber) {

        rxService.getAll()
                .map(new MenuInfoFun())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 添加一条数据
     *
     * @param subscriber
     */
    public void insertOne(Subscriber<String> subscriber) {

        rxService.insertOne()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
