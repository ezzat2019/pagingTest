package com.example.programmer.pagingtest.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.programmer.pagingtest.models.PhotoModel;
import com.example.programmer.pagingtest.sources.CustomDataSource;
import com.example.programmer.pagingtest.sources.CustomResourceFac;

public class MainviewModel extends AndroidViewModel {

    private LiveData<PagedList<PhotoModel>> list;
    private CustomResourceFac fac;

    public LiveData<PagedList<PhotoModel>> getList() {
        return list;
    }

    public MainviewModel(@NonNull Application application) {
        super(application);
        fac=new CustomResourceFac();
        PagedList.Config config=new PagedList.Config.Builder().setEnablePlaceholders(false)
                .setPageSize(CustomDataSource.first_val)
                .build();

        list=new LivePagedListBuilder<>(fac,config).build();

    }
}
