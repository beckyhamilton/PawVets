package com.example.PawVets.Model;

public class Review {
    private int Stars;
    private String Description;

    public Review() {

    }

    public Review( int stars, String description)   {
        Stars = stars;
        Description = description;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int stars) {
        Stars = stars;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}




