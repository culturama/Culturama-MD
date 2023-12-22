package com.example.culturama.model;

import com.google.gson.annotations.SerializedName;

public class CulturamaResponse {
    @SerializedName("culturama")
    private Culturama culturama;
    @SerializedName("error")
    private boolean error;
    @SerializedName("message")
    private String message;
    public Culturama getCulturama(){
        return culturama;
    }
    public boolean isError(){
        return error;
    }
    public String getMessage(){
        return message;
    }
}