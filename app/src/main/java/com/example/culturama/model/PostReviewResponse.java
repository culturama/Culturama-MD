package com.example.culturama.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostReviewResponse {
    @SerializedName("customerReviews")
    private List<UserReviewsItem> customerReviews;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public List<UserReviewsItem> getCustomerReviews(){
        return customerReviews;
    }

    public boolean isError(){
        return error;
    }

    public String getMessage(){
        return message;
    }
}