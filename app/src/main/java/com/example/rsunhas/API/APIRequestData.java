package com.example.rsunhas.API;

import com.example.rsunhas.Model.ResponseModel;
import com.example.rsunhas.Model.ResponseModel2;
import com.example.rsunhas.Model.ResponseModel3;
import com.example.rsunhas.Model.ResponseModel5;
import com.example.rsunhas.Model.ResponseModelkmr;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @GET("retrieve3.php")
    Call<ResponseModel3> ardRetrieveObgin();

    @GET("retrieve5.php")
    Call<ResponseModel5> ardRetrieveTht();


    @GET("retrievekamar.php")
    Call<ResponseModelkmr> ardRetrieveKamar();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel2> ardCreateData(
            @Field("nama") String nama,
            @Field("lahir") String lahir,
            @Field("notelepon") String notelepon,
            @Field("kunjungan") String kunjungan,
            @Field("rekmed") String rekmed);


    @FormUrlEncoded
    @POST("create3.php")
    Call<ResponseModel3> ardCreateObgin(
            @Field("nama") String nama,
            @Field("lahir") String lahir,
            @Field("notelepon") String notelepon,
            @Field("kunjungan") String kunjungan,
            @Field("rekmed") String rekmed);


    @FormUrlEncoded
    @POST("create5.php")
    Call<ResponseModel5> ardCreateTht(
            @Field("nama") String nama,
            @Field("lahir") String lahir,
            @Field("notelepon") String notelepon,
            @Field("kunjungan") String kunjungan,
            @Field("rekmed") String rekmed);
}

