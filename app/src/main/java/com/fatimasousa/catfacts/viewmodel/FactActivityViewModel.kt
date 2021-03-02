package com.fatimasousa.catfacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatimasousa.catfacts.model.FactsModel
import com.fatimasousa.catfacts.repository.FactActivityRepository

class FactActivityViewModel : ViewModel() {

    //atualiza apenas os observadores de componentes e avisa
    var servicesLiveData : MutableLiveData<FactsModel>? = null

    fun getFact() : LiveData<FactsModel>? {
        servicesLiveData = FactActivityRepository.getServicesApiCall()
        return servicesLiveData
    }
}