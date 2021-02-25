package com.fatimasousa.catfacts.model

import com.google.gson.annotations.SerializedName

class FactModel {

    @SerializedName("_id")
    var id : String = ""

    @SerializedName("type")
    var type : String = ""

    @SerializedName("text")
    var text : String = ""

}

