package com.example.starwarsapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.starwarsapp2.databinding.ActivityMainLayoutBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainLayoutBinding.inflate(layoutInflater).root)
    }
}