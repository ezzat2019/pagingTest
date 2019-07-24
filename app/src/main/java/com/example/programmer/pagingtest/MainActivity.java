package com.example.programmer.pagingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.programmer.pagingtest.adapters.RecAdapter;
import com.example.programmer.pagingtest.models.PhotoModel;
import com.example.programmer.pagingtest.view_models.MainviewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainviewModel mainviewModel;
    private RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter=new RecAdapter(getApplicationContext());
        mainviewModel= ViewModelProviders.of(this).get(MainviewModel.class);
        mainviewModel.getList().observe(this, new Observer<PagedList<PhotoModel>>() {
            @Override
            public void onChanged(PagedList<PhotoModel> photoModels) {
                adapter.submitList(photoModels);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
