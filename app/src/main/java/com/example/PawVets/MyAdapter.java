package com.example.PawVets;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.PawVets.Model.Model;
import com.example.PawVets.Model.MyHolder;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    final String FBpageURL = "fb://page/Vets4PetsGroup/";

    Context c;
    ArrayList<Model> models;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {

    myHolder.mTitle.setText(models.get(i).getTitle());
    myHolder.mDes.setText(models.get(i).getDescription());
    myHolder.mImageView.setImageResource(models.get(i).getImg());

    myHolder.setItemClickListener(new ItemClickListener() {
        @Override
        public void onItemClickListener(View v, int position) {
            String gTitle = models.get(position).getTitle();
            String gDesc = models.get(position).getTitle();
            BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable();

            Bitmap bitmap = bitmapDrawable.getBitmap();

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            byte[] bytes = stream.toByteArray();

            Intent intent = new Intent(c, AnotherActivity.class);
            intent.putExtra("iTitle", gTitle);
            intent.putExtra("iDesc", gDesc);
            intent.putExtra("iImage",bytes);
            c.startActivity(intent);

            myHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onItemClickListener(View v, int position) {
                    if (models.get(position).getTitle().equals("Paw Vets")) {
                        Intent openFB = new Intent(Intent.ACTION_VIEW);
                        openFB.setData(Uri.parse(FBpageURL));

                    }

                }
            });
        }
    });


    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
