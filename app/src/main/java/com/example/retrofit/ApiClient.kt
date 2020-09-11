package com.example.retrofit

import com.example.retrofit.pojo.Recipe
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiClient {

    @GET("/")
    @Headers("x-rapidapi-host: recipe-puppy.p.rapidapi.com",
    "x-rapidapi-key: EiQ7kK3duCmshADAOmgDD7gCtoPBp1IXVX0jsn1fuDYkGmBXes")
    suspend fun getFetchFromServer(): Response<Recipe>


    @GET("/")
    @Headers("x-rapidapi-host: recipe-puppy.p.rapidapi.com",
        "x-rapidapi-key: EiQ7kK3duCmshADAOmgDD7gCtoPBp1IXVX0jsn1fuDYkGmBXes")
     fun getFetchFromServerEnquee(): Call<Recipe>


}