package com.example.starwarsapp2.data.fake

import com.example.starwarsapp2.data.starwarsapi.StarWarsApi
import com.example.starwarsapp2.data.starwarsapi.StarWarsNetwork
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import retrofit2.Response

class FakeStarWarsNetwork : StarWarsNetwork {

    var peopleResponse: Response<PeopleResponse>? = null

    override val starWarsApi: StarWarsApi = object : StarWarsApi {

        override fun getPeople(): Response<PeopleResponse> =
            peopleResponse ?: error("Response not provided")
    }
}