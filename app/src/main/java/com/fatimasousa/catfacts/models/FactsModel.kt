package com.fatimasousa.catfacts.models

import com.google.gson.annotations.SerializedName

class FactsModel {

    @SerializedName("_id")
    var id : String = ""

    @SerializedName("type")
    var type : String = ""

    @SerializedName("text")
    var text : String = ""


}

