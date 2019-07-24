package com.example.programmer.pagingtest.ui;

import androidx.paging.PagedList;

import com.example.programmer.pagingtest.models.PhotoModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoApi {
@GET("photos")
    Call<PagedList<PhotoModel>>getPhotoes();
}
