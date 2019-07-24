package com.example.programmer.pagingtest.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.programmer.pagingtest.R;
import com.example.programmer.pagingtest.models.PhotoModel;

public class RecAdapter extends PagedListAdapter<PhotoModel, RecAdapter.VH> {
    private static Context context1;

    private static DiffUtil.ItemCallback<PhotoModel> diffCallback = new DiffUtil.ItemCallback<PhotoModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull PhotoModel oldItem, @NonNull PhotoModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull PhotoModel oldItem, @NonNull PhotoModel newItem) {
            return oldItem.getUrl().equals(newItem.getUrl());
        }
    };

    public RecAdapter(Context context) {
        super(diffCallback);
        context1 = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rec22,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bindData(getItem(position));

    }

    public static class VH extends RecyclerView.ViewHolder {
        private TextView txt_name;
        private ImageView imageView;

        public VH(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            imageView = itemView.findViewById(R.id.img);
        }

        public void bindData(PhotoModel model) {
            txt_name.setText(model.getTitle());

            txt_name.setSelected(true);
            Glide.with(context1).load(model.getUrl()).into(imageView);
        }
    }
}
