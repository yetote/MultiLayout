package com.example.admin.multilayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.multilayout.adapter.MyAdapter;
import com.example.admin.multilayout.model.TestModel;
import com.example.admin.multilayout.retrofit.services.TestServices;
import com.example.admin.multilayout.utils.MyDecoration;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * com.example.admin.multilayout.MainActivity
 *
 * @author Swg
 * @date 2017/12/7 12:47
 */
public class MainActivity extends AppCompatActivity {
    private List<TestModel> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);

        rv.setAdapter(adapter);
        rv.addItemDecoration(new MyDecoration(this));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://47.95.206.238/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        TestServices testServices = retrofit.create(TestServices.class);

        testServices.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(testModels -> {
                    list.addAll(testModels);
                    adapter.notifyDataSetChanged();
                });

    }

}
