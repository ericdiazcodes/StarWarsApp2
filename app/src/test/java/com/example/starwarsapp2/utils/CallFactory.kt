package com.example.starwarsapp2.utils

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object CallFactory {

    fun <T> generateCall(response: Response<T>?): Call<T> {
        return object : Call<T> {

            override fun clone(): Call<T> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<T> =
                response ?: error("Response not provided")

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

            override fun enqueue(callback: Callback<T>) {
                response?.let {
                    if (it.isSuccessful) {
                        callback.onResponse(this, it)
                    } else {
                        callback.onFailure(this, IllegalStateException(response.message()))
                    }
                }
            }
        }
    }
}