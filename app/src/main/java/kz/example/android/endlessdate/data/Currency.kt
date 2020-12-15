package kz.example.android.endlessdate.data

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("Name") val name: String,
    @SerializedName("Nominal") val nominal: Int,
    @SerializedName("Value") val value: Double
){
    fun getNominalizedValue(): Double {
        return value/nominal
    }
}