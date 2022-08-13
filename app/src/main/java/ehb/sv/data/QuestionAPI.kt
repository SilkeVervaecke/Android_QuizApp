package ehb.sv.data

import android.util.Log
import ehb.sv.BASE_URL
import ehb.sv.classes.QuestnItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.StringBuilder


const val BASE_URL = " https://the-trivia-api.com/api/"

public fun getQuestData(): List<QuestnItem> {
    var data: List<QuestnItem> = emptyList()
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface::class.java)

    val retrofitData = retrofitBuilder.getData()

    retrofitData.enqueue(object : Callback<List<QuestnItem>?> {
        override fun onResponse(
            call: Call<List<QuestnItem>?>,
            response: Response<List<QuestnItem>?>
        ) {
            val mystringBuilder = StringBuilder()
            val responseBody = response.body()!!
            for (small in responseBody) {
                println(small)
                mystringBuilder.append(small.question).append("\n")
            }
//                binding.welcomeText.text = mystringBuilder
            data = responseBody
        }

        override fun onFailure(call: Call<List<QuestnItem>?>, t: Throwable) {
            Log.d("MainActivity", "on Failure: " + t.message)

        }
    })
    return data
}


//var baseurl ="https://opentdb.com/"

//@GET("group/{id}/users")
//fun groupList(@Path("id") groupId: Int): Call<List<ApiAnswer?>?>?
//@GET("group/{id}/users")
//var Call<List<User>> groupList(@Path("id") int groupId);

//@GET("users/{username}")
//Call<User> getUser(@Path("username") String username);

//////////////////
//object LocationApi {
//    private const val BASE_URL_LOCATION = "https://api.ipgeolocation.io/"
//    const val API_KEY = "8ebc893bd8a141e49287b119b618a97f"
//    private const val BASE_URL_WEATHER = "https://api.openweathermap.org/data/2.5/"
//    const val APPID = "d7b955c4c268fe54649d6f0d702b39d1"
//
//    private val moshi = Moshi.Builder()
//        .add(LocalDateJsonAdapter()).add(LocalTimeJsonAdapter())
//        .add(KotlinJsonAdapterFactory()).build()
//
//    private val retrofitLocation = Retrofit.Builder()
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .baseUrl(BASE_URL_LOCATION).build()
//
//    private val retrofitWeather = Retrofit.Builder()
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .baseUrl(BASE_URL_WEATHER).build()
//
//    val retrofitLocationService: LocationRemoteDataStore by lazy {
//        retrofitLocation.create(
//            LocationRemoteDataStore::class.java
//        )
//    }
//    val retrofitWeatherService: LocationRemoteDataStore by lazy {
//        retrofitWeather.create(
//            LocationRemoteDataStore::class.java
//        )
//    }
//}