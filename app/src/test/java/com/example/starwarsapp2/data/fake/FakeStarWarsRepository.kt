package com.example.starwarsapp2.data.fake

import com.example.starwarsapp2.data.starwarsapi.repository.StarWarsRepository
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import com.example.starwarsapp2.utils.CallFactory
import retrofit2.Call
import retrofit2.Response

class FakeStarWarsRepository : StarWarsRepository {

    var peopleResponse: Response<PeopleResponse>? = null

    override fun getPeople(): Call<PeopleResponse> = CallFactory.generateCall(peopleResponse)
}