package com.example.PawVets;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

//Creating and configuring adapter
public class RecyclerViewAdaptery extends RecyclerView.Adapter<RecyclerViewAdaptery.ImageViewHolder> {

    //Variables
    Context mContext;
    List<row> mData;

    //Constructor
    public RecyclerViewAdaptery(Context mContext, List<row> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // ImageView holder - binding views
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        //Adding Glide library to load images faster
        Glide.
                with(mContext)
                .load(mData.get(position).getImg())
                        .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);

            //onClick Listener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        //Open Settings if settings icon clicked
        if(getLayoutPosition() == 0)
            {
        Intent settings = new Intent(mContext,Settings.class);
          mContext.startActivity(settings);
          }

        //Open Contact Us if contact us icon clicked
            if(getLayoutPosition() == 1)
            {
                Intent contactus = new Intent(mContext,ContactUs.class);
                mContext.startActivity(contactus);
            }

        //Open Appointment if book appointment icon clicked
            if(getLayoutPosition() == 2)
            {
                Intent appt = new Intent(mContext,Appointment.class);
                mContext.startActivity(appt);
            }

        //Open MyAccount if my account icon clicked
            if(getLayoutPosition() == 3)
            {
                Intent myaccount = new Intent(mContext,MyAccount.class);
                mContext.startActivity(myaccount);
            }

        //Open SymptomChecker if my symptom checker icon clicked
            if(getLayoutPosition() == 4)
            {
                Intent symptom = new Intent(mContext,SymptomChecker.class);
                mContext.startActivity(symptom);
            }

        //Open FindUs if my where to find us icon clicked
            if(getLayoutPosition() == 5)
            {
                Intent myshopping = new Intent(mContext,MyShopping.class);
                mContext.startActivity(myshopping);
            }
            }

        }
    }

