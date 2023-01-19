package com.example.starwarsapp2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.starwarsapp2.data.starwarsapi.repository.StarWarsRepository
import com.example.starwarsapp2.data.starwarsapi.response.PeopleResponse
import retrofit2.Call
import retrofit2.Response

class StarWarsViewModel(
    private val starWarsRepository: StarWarsRepository
) : ViewModel() {

    private var callback: Callback? = null

    class Callback(
        private var success: ((peopleResponse: PeopleResponse) -> Unit),
        private var error: ((message: String) -> Unit)
    ) : retrofit2.Callback<PeopleResponse> {

        override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
            if (response.isSuccessful) {
                response.body()?.let { success(it) } ?: error(response.message())
            } else {
                error(response.message())
            }
        }

        override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
            error(t.message.toString())
        }
    }

    fun addCallback(callback: Callback) {
        this.callback = callback
    }

    fun removeCallback() {
        this.callback = null
    }

    fun getPeople() {
        callback?.let { starWarsRepository.getPeople().enqueue(it) }
    }

    override fun onCleared() {
        removeCallback()
        super.onCleared()
    }
}