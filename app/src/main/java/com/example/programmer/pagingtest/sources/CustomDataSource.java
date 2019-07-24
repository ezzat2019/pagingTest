package com.example.programmer.pagingtest.sources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.programmer.pagingtest.models.PhotoModel;
import com.example.programmer.pagingtest.repositry.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomDataSource extends PageKeyedDataSource<Integer, PhotoModel> {
    public static int first_val = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, PhotoModel> callback) {
        RetrofitBuilder.getInstance().getApi().getPhotoes().enqueue(new Callback<PagedList<PhotoModel>>() {
            @Override
            public void onResponse(Call<PagedList<PhotoModel>> call, Response<PagedList<PhotoModel>> response) {
                callback.onResult(response.body(), null, first_val);
            }

            @Override
            public void onFailure(Call<PagedList<PhotoModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoModel> callback) {
        RetrofitBuilder.getInstance().getApi().getPhotoes().enqueue(new Callback<PagedList<PhotoModel>>() {
            @Override
            public void onResponse(Call<PagedList<PhotoModel>> call, Response<PagedList<PhotoModel>> response) {
                Integer k;

                if (params.key > 1) {
                    k = params.key - 1;

                } else k = null;
                callback.onResult(response.body(), k);
            }

            @Override
            public void onFailure(Call<PagedList<PhotoModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoModel> callback) {
        RetrofitBuilder.getInstance().getApi().getPhotoes().enqueue(new Callback<PagedList<PhotoModel>>() {
            @Override
            public void onResponse(Call<PagedList<PhotoModel>> call, Response<PagedList<PhotoModel>> response) {

                Integer k;
                if (!response.body().isEmpty()) {
                    k = params.key + 1;
                } else
                    k = null;

                callback.onResult(response.body(), k);


            }

            @Override
            public void onFailure(Call<PagedList<PhotoModel>> call, Throwable t) {

            }
        });
    }
}
