package com.mohamdaoui.doordash.network

import com.mohamdaoui.doordash.model.Store
import com.mohamdaoui.doordash.model.StoreFeedResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiDataService {
    @GET("/v1/store_feed")
    fun getHomeFeed(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<StoreFeedResult>

    @GET("/v2/restaurant/{id}")
    fun getRestaurantDetails(
        @Path("id") id: Int
    ): Call<Store>
}