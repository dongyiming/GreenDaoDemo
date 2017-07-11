package com.example.gd_rxjava_retrofit.convert;

import com.example.gd_bean_ui.vo.ncVo.NcMenu;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/9 18:21
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<?> adapter;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<?> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        String string = value.string();
        //数组的解析方法
        List<NcMenu> menuList = gson.fromJson(string, new TypeToken<List<NcMenu>>() {
        }.getType());
        return (T) menuList;
    }

}
