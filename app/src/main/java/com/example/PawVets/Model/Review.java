package com.example.PawVets.Model;

import android.widget.RatingBar;

public class Review {
    private RatingBar ratingBar1;
    private String description1;

    public Review() {

    }

    public Review(RatingBar ratingBar, String description) {
        ratingBar1 = ratingBar;
        description1 = description;
    }

    public RatingBar getRatingBar1() {
        return ratingBar1;
    }

    public String getDescription1() {
        return description1;
    }
}





