package com.fatimasousa.catfacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatimasousa.catfacts.repository.FactActivityRepository
import com.fatimasousa.catfacts.service.FactsService

class FactActivityViewModel : ViewModel() {

    var servicesLiveData : MutableLiveData<FactsService>? = null

    fun getUser() : LiveData<FactsService> {
        servicesLiveData = FactActivityRepository.
    }
}