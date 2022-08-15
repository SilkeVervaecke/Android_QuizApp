package ehb.sv.data

import ehb.sv.classes.Questn
import ehb.sv.classes.QuestnItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("questions")
    fun getData(): Call<List<QuestnItem>>
}

interface ApiInterface_suspend {
    @GET("questions")
    suspend fun getData(): List<QuestnItem>
}

interface ApiInterface_old {
    @GET("questions")
    fun getData(): Call<List<QuestnItem>>
}