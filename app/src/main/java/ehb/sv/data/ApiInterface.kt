package ehb.sv.data

import ehb.sv.classes.QuestnItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
//    @GET("api.php?amount=10")
    @GET("questions")
    fun getData(): Call<List<QuestnItem>>
}