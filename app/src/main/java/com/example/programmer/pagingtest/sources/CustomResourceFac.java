package com.example.programmer.pagingtest.sources;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.example.programmer.pagingtest.models.PhotoModel;

public class CustomResourceFac extends DataSource.Factory<Integer, PhotoModel> {
    @NonNull
    @Override
    public DataSource<Integer, PhotoModel> create() {
        CustomDataSource customDataSource=new CustomDataSource();

        return customDataSource;
    }
}
