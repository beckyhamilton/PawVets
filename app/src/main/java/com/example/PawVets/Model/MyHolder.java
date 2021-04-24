package com.example.PawVets.Model;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.example.PawVets.ItemClickListener;
import com.example.PawVets.R;


public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView mImageView;
    public TextView mTitle, mDes;
    ItemClickListener itemClickListener;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.image1);
        this.mTitle = itemView.findViewById(R.id.title1);
        this.mDes = itemView.findViewById(R.id.description1);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        this.itemClickListener.onItemClickListener(v, getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
}
