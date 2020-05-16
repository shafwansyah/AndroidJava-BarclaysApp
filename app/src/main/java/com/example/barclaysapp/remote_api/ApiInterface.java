package com.example.barclaysapp.remote_api;

import com.example.barclaysapp.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/v1/json/1/search_all_teams.php")
    Call<Response> getAllTeam(
            @Query("l") String nameLeague
    );
}
