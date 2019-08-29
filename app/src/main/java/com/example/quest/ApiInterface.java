package com.example.quest;

import com.example.quest.model.Mains;
import com.example.quest.model.advanced;
import com.example.quest.model.advancedppr;
import com.example.quest.model.mhtcet;
import com.example.quest.model.neet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/v1/twelfth_question_papers/year_list?category=mains")
    Call <List<Mains>> getdata();
    @GET("/v1/twelfth_question_papers/year_list?category=advanced")
    Call <List<advanced>> getalldata();
    @GET("/v1/twelfth_question_papers/year_list?category=neet")
    Call <List<neet>> getneetdata();
    @GET("/v1/twelfth_question_papers/year_list?category=mhcet")
    Call <List<mhtcet>> getcetdata();
    @GET("/v1/twelfth_question_papers/question_papers_list?year_id=1&subject=")
    Call <List<advancedppr>> getadvdata();
}
