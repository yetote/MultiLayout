package com.example.admin.multilayout.retrofit.services;

import com.example.admin.multilayout.model.TestModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * com.example.admin.multilayout.retrofit.services
 *
 * @author Swg
 * @date 2017/12/7 12:47
 */
public interface TestServices {
    /**
     * 获取mulitLayout_sc.php中返回的数据
     * @return testModel类型的列表
     */
    @GET("mulitLayout_sc.php")

    Observable<List<TestModel>> getData();
}
