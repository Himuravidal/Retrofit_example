package com.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.pojo.Recipe

class ViewModelExample : ViewModel(){

    private val repository = RepositoryExample()
    init {
        repository.getFetchFromServer()
    }


    fun exposeLiveDataFromServer(): LiveData<Recipe> {
       return repository.liveDataFromServer
    }

}