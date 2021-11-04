package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.modelview.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getShortenURL()



        binding.btnEncurtar.setOnClickListener {

            val url = binding.inputUrl.text.toString()
            mainViewModel.shortenURLFunc(url)

        }
    }

    private fun getShortenURL() {
        mainViewModel.shortenURLResponse.observe(this, {response ->

            when(response) {
                is String -> binding.txtUrlEncurtada.text = response
            }

        })
    }
}