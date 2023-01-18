package com.example.starwarsapp2.data.starwarsapi

import com.example.starwarsapp2.data.RetrofitProvider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

interface StarWarsNetwork {

    val starWarsApi: StarWarsApi
}

class StarWarsNetworkImpl : StarWarsNetwork {

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

    override val starWarsApi = RetrofitProvider.getRetrofit(
        baseUrl = BASE_URL,
        client = client,
        converterFactories = listOf(GsonConverterFactory.create()),
        callAdapterFactories = emptyList()
    ).create(StarWarsApi::class.java)

    companion object {

        private const val BASE_URL = "https://swapi.dev/api/"
    }
}