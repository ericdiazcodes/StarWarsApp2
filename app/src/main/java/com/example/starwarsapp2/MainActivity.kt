package com.example.starwarsapp2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsapp2.data.starwarsapi.StarWarsNetworkImpl
import com.example.starwarsapp2.data.starwarsapi.repository.StarWarsRepositoryImpl
import com.example.starwarsapp2.databinding.ActivityMainLayoutBinding
import com.example.starwarsapp2.viewmodel.StarWarsViewModel
import com.example.starwarsapp2.viewmodel.StarWarsViewModelFactory

class MainActivity : AppCompatActivity() {

    private val starWarsNetwork = StarWarsNetworkImpl()
    private val starWarsRepository = StarWarsRepositoryImpl(starWarsNetwork)
    private var callback: StarWarsViewModel.Callback = StarWarsViewModel.Callback(
        success = {
            Toast.makeText(this@MainActivity, it.count.toString(), Toast.LENGTH_LONG).show()
        },
        error = {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_LONG).show()
        }
    )
    private val starWarsViewModelFactory = StarWarsViewModelFactory(starWarsRepository)
    private val starWarsViewModel: StarWarsViewModel by lazy {
        ViewModelProvider(this, starWarsViewModelFactory)[StarWarsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainLayoutBinding.inflate(layoutInflater).root)
    }

    override fun onStart() {
        super.onStart()
        starWarsViewModel.addCallback(callback)
        starWarsViewModel.getPeople()
    }

    override fun onStop() {
        super.onStop()
        starWarsViewModel.removeCallback()
    }
}