package com.example.starwarsapp2.data.starwarsapi.repository

import com.example.starwarsapp2.data.starwarsapi.StarWarsNetwork
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import retrofit2.Call

interface StarWarsRepository {

    fun getPeople(): Call<PeopleResponse>
}

class StarWarsRepositoryImpl(private val starWarsNetwork: StarWarsNetwork) : StarWarsRepository {

    override fun getPeople(): Call<PeopleResponse> {
        return starWarsNetwork.starWarsApi.getPeople()
    }
}