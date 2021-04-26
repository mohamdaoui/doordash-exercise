package com.mohamdaoui.doordash.model

import com.google.gson.annotations.SerializedName

class Store(var id: Int, var name: String, var description: String) {

    @SerializedName("distance_from_consumer")
    var distance: Number? = null

    @SerializedName("cover_img_url")
    lateinit var coverImage: String

    @SerializedName("average_rating")
    lateinit var averageRating: Number

    @SerializedName("number_of_ratings")
    var numberOfRatings: Number? = null

    @SerializedName("delivery_fee")
    lateinit var deliveryFee: Number

}