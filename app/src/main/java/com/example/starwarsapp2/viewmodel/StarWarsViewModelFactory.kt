package com.example.starwarsapp2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsapp2.data.starwarsapi.repository.StarWarsRepository

class StarWarsViewModelFactory(
    private val starWarsRepository: StarWarsRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        if (modelClass.isAssignableFrom(StarWarsViewModel::class.java)) {
            StarWarsViewModel(starWarsRepository) as T
        } else error("No factoryProvider for ${modelClass.name}")
}