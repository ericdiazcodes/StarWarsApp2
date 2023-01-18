package com.example.starwarsapp2.data.starwarsapi.repository

import com.example.starwarsapp2.data.starwarsapi.StarWarsNetwork
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse

class StarWarsRepository(private val starWarsNetwork: StarWarsNetwork) {

    fun getPeople(): PeopleResponse {
        val call = starWarsNetwork.starWarsApi.getPeople()
        if (call.isSuccessful) {
            return call.body() ?: error("Call was successful but body was null")
        } else {
            error(call.message())
        }
    }
}