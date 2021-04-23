package com.mohamdaoui.doordash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mohamdaoui.doordash.model.Store
import com.mohamdaoui.doordash.model.StoreFeedResult
import com.mohamdaoui.doordash.respository.StoreRepository

class MainViewModel : ViewModel() {
    private val storeRepository: StoreRepository = StoreRepository()

    fun getHomeFeed(): LiveData<StoreFeedResult> {
        return storeRepository.getHomeFeed(
            lat = 37.422740,
            lng = -122.139956,
            offset = 0,
            limit = 50
        )
    }

    fun getRestaurantDetails(id: Int): LiveData<Store> {
        return storeRepository.getRestaurantDetails(id = id)
    }

}