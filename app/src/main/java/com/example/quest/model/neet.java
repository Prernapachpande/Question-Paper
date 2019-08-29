package com.example.quest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class neet {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("file")
    @Expose
    private String file;

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}
