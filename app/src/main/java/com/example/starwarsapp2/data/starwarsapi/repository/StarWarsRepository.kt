package com.example.starwarsapp2.data.starwarsapi.repository

import com.example.starwarsapp2.data.starwarsapi.StarWarsNetwork
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import retrofit2.Call

class StarWarsRepository(private val starWarsNetwork: StarWarsNetwork) {

    fun getPeople(): Call<PeopleResponse> {
        return starWarsNetwork.starWarsApi.getPeople()
    }
}