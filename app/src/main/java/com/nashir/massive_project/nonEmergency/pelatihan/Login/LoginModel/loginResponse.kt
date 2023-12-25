package com.nashir.massive_project.NonEmergency.Pelatihan.Login.LoginModel
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("value") val value: Int,
    @SerializedName("message") val message: String
)
