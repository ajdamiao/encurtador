package com.example.myapplication.modelview

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.ShortenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel {

    private val apiRepository = ShortenRepository().makeRequest()
    val shortenURLResponse: MutableLiveData<String> = MutableLiveData()


    fun shortenURLFunc(url: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val response = apiRepository.encurtar(url)

                shortenURLResponse.postValue(response.result.short_link)

            }catch (exception: Exception){
                println("NAO DEU BOM ${exception.message}")
            }
        }
    }
}