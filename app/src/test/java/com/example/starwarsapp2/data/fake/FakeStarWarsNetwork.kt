package com.example.starwarsapp2.data.fake

import com.example.starwarsapp2.data.starwarsapi.StarWarsApi
import com.example.starwarsapp2.data.starwarsapi.StarWarsNetwork
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FakeStarWarsNetwork : StarWarsNetwork {

    var peopleResponse: Response<PeopleResponse>? = null

    override val starWarsApi: StarWarsApi = object : StarWarsApi {

        override fun getPeople(): Call<PeopleResponse> = object : Call<PeopleResponse> {

            override fun clone(): Call<PeopleResponse> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<PeopleResponse> =
                peopleResponse ?: error("Response not provided")

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<PeopleResponse>) {
                TODO("Not yet implemented")
            }
        }
    }
}