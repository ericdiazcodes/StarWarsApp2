package com.example.starwarsapp2.data.model

import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import com.example.starwarsapp2.data.starwarsapi.response.Person
import okhttp3.ResponseBody
import retrofit2.Response

object PeopleResponseFixtures {

    val person = Person(
        name = "Eric",
        height = "44"
    )
    val peopleResponse = PeopleResponse(
        count = 100,
        nextGroup = "test.com",
        previousGroup = "test3.com",
        result = listOf(person)
    )

    val success: Response<PeopleResponse> = Response.success(peopleResponse)

    val error: Response<PeopleResponse> = Response.error(
        400,
        ResponseBody.Companion.create(null, "Random Test Error")
    )
}