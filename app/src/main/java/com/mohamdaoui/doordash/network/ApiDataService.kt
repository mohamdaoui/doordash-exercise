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

    // I see the menu object in this response does not contain the menu information,
    // which leads me to believe there is a /menus endpoint? I could not guess it so I did not show the menus.
    // I could use the previous feed call since it has the menus pass the info to the new activity (making it parcelable), but I don't think that's a good pattern.
    @GET("/v2/restaurant/{id}")
    fun getRestaurantDetails(
        @Path("id") id: Int
    ): Call<Store>
}