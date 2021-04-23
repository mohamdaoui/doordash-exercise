package com.mohamdaoui.doordash.model

import com.google.gson.annotations.SerializedName

data class StoreFeedResult(var stores: ArrayList<Store>? = null) {

    @SerializedName("num_results")
    private lateinit var numResults: Number

    @SerializedName("next_offset")
    private lateinit var nextOffset: Number

}