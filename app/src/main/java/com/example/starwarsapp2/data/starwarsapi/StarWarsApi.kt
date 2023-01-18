package com.example.starwarsapp2.data.starwarsapi

import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {

    @GET("people")
    fun getPeople(): Response<PeopleResponse>
}