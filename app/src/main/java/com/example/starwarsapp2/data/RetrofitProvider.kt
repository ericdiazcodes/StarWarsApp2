package com.example.starwarsapp2.data

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit

object RetrofitProvider {

    fun getRetrofit(
        baseUrl: String,
        client: OkHttpClient,
        converterFactories: List<Converter.Factory>,
        callAdapterFactories: List<CallAdapter.Factory>
    ): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)

        converterFactories.forEach {
            retrofit.addConverterFactory(it)
        }

        callAdapterFactories.forEach {
            retrofit.addCallAdapterFactory(it)
        }

        return retrofit.build()
    }

}