package com.example.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.pojo.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryExample() {

    private val services = RetrofitClient.getRetrofit()
    val liveDataFromServer : MutableLiveData<Recipe> = MutableLiveData()

    // Este realiza una conexión a un endPoint y utiliza corutinas con runCatching para manejar los estados.
    // Utiliza Corutinas mas nuevito.
    fun getFetchFromServer() = CoroutineScope(Dispatchers.IO).launch {
        val service = runCatching {services.getFetchFromServer() }
            service.onSuccess {
                liveDataFromServer.postValue(it.body())
            }
            service.onFailure {
                Log.e("ERROR", it.message.toString())
            }
    }

    //Este es el metodo tradicional asincrono enque de Retrofit.(vieja confiable)
    fun getDataFromServerEnque() {
        val call = services.getFetchFromServerEnquee()
        call.enqueue(object :  Callback<Recipe> {
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                liveDataFromServer.postValue(response.body())
            }
            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}