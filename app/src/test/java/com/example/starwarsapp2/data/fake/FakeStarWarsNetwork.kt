package com.example.starwarsapp2.data.fake

import com.example.starwarsapp2.data.starwarsapi.StarWarsApi
import com.example.starwarsapp2.data.starwarsapi.StarWarsNetwork
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import com.example.starwarsapp2.utils.CallFactory
import retrofit2.Call
import retrofit2.Response

class FakeStarWarsNetwork : StarWarsNetwork {

    var peopleResponse: Response<PeopleResponse>? = null

    override val starWarsApi: StarWarsApi = object : StarWarsApi {

        override fun getPeople(): Call<PeopleResponse> =
            CallFactory.generateCall(peopleResponse)
    }
}