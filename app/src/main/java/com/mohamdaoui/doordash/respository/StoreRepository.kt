package com.mohamdaoui.doordash.respository

import androidx.lifecycle.MutableLiveData
import com.mohamdaoui.doordash.model.Store
import com.mohamdaoui.doordash.model.StoreFeedResult
import com.mohamdaoui.doordash.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreRepository {

    // If we use the custom callback I defined, we can remove repetition from this class

    fun getHomeFeed(
        lat: Double,
        lng: Double,
        offset: Int,
        limit: Int
    ): MutableLiveData<StoreFeedResult> {
        val mutableLiveData = MutableLiveData<StoreFeedResult>()
        val userDataService = RetrofitClient.service
        val call =
            userDataService.getHomeFeed(lat = lat, lng = lng, offset = offset, limit = limit)

        call.enqueue(object : Callback<StoreFeedResult> {
            override fun onFailure(call: Call<StoreFeedResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<StoreFeedResult>,
                response: Response<StoreFeedResult>
            ) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun getRestaurantDetails(
        id: Int
    ): MutableLiveData<Store> {
        val mutableLiveData = MutableLiveData<Store>()
        val userDataService = RetrofitClient.service
        val call =
            userDataService.getRestaurantDetails(id = id)

        call.enqueue(object : Callback<Store> {
            override fun onFailure(call: Call<Store>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<Store>,
                response: Response<Store>
            ) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }
}