package com.fatimasousa.catfacts.model

import com.google.gson.annotations.SerializedName

data class FactsModel (

    @SerializedName("text")
    val text: String? = null
)


