package com.example.quest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class advancedppr {
    @SerializedName("paper_id")
    @Expose
    private String paperId;
    @SerializedName("paper")
    @Expose
    private String paper;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("year_id")
    @Expose
    private String yearId;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

}
