package ehb.sv.data

import android.util.Log
import ehb.sv.classes.Questn
import ehb.sv.classes.QuestnItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestRetriever {

//    companion object{
//        private val apiInterface :ApiInterface
//
//        var url = ehb.sv.BASE_URL
//        init {
//            val retrofit = Retrofit
//                .Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            apiInterface = retrofit.create(ApiInterface::class.java)
//        }
//        }
        companion object {
        var retrofitService: ApiInterface? = null
        fun getInstance() : ApiInterface {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(ehb.sv.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiInterface::class.java)
            }
            return retrofitService!!
        }


    suspend fun getQuestions(): Call<List<QuestnItem>> {
        println("in subfunction")
        return getInstance().getData()


    }
    }

}