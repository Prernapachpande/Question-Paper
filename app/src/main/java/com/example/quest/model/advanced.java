package com.example.quest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class advanced {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("year")
    @Expose
    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
