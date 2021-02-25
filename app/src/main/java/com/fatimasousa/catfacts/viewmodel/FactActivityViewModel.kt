package com.fatimasousa.catfacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatimasousa.catfacts.model.FactModel
import com.fatimasousa.catfacts.repository.FactActivityRepository

class FactActivityViewModel : ViewModel() {

    var servicesLiveData : MutableLiveData<FactModel>? = null

    fun getUser() : LiveData<FactModel>? {
        servicesLiveData = FactActivityRepository.callApi()
        return servicesLiveData
    }
}