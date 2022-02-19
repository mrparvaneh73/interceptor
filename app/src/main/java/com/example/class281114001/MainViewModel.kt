package com.example.class281114001

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException

class MainViewModel:ViewModel() {

    private val _data = MutableLiveData<String>()
    val data:LiveData<String> = _data

    init {
        val request = Request.Builder().url("https://github.com/mrparvaneh73").build()
        NetWorkManager.client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                    _data.postValue(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                _data.postValue(response.body()?.string())
            }

        })

    }


}