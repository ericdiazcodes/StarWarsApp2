package com.example.starwarsapp2.data.starwarsapi.response

import com.google.gson.annotations.SerializedName

data class PeopleResponse(
    val count: Int,
    @SerializedName("next")
    val nextGroup: String,
    @SerializedName("previous")
    val previousGroup: String,
    val result: List<Person>
)