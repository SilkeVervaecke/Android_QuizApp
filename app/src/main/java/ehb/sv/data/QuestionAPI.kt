package ehb.sv.data

import android.util.Log
import ehb.sv.BASE_URL
import ehb.sv.classes.QuestnItem
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.StringBuilder


const val BASE_URL = " https://the-trivia-api.com/api/"

public fun getQuestData(): Call<List<QuestnItem>> {
    println("in get quest function")
    var data: List<QuestnItem> = emptyList()
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface_old::class.java)

    val retrofitData = retrofitBuilder.getData()

    retrofitData.enqueue(object : Callback<List<QuestnItem>?> {
        override fun onResponse(
            call: Call<List<QuestnItem>?>,
            response: Response<List<QuestnItem>?>
        ) {
            println(response)
            val responseBody = response.body()!!
            data = responseBody
//            println(data)
        }

        override fun onFailure(call: Call<List<QuestnItem>?>, t: Throwable) {
            println("API call gives error: "+t.message)
            Log.d("API call for questions", "on Failure: " + t.message)
        }
    })
    return retrofitData
//    var aaa = retrofitData.execute()
//    var body = aaa.body()
//    if(body!=null){
//        return body
//    }else{
//        return emptyList()
//    }
//    if (aaa.isSuccessful){
//        return aaa.body()!!
//    }else{
//        println("could not get data, "+ aaa.errorBody())
//        return emptyList()
//    }
//    println("before returning: "+ data)
//
//    return data
}

suspend fun getQuestData_suspend(): List<QuestnItem> {
    var data: List<QuestnItem> = emptyList()
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface_suspend::class.java)

    val retrofitData = retrofitBuilder.getData()

//    retrofitData.enqueue(object : Callback<List<QuestnItem>?> {
//        override fun onResponse(
//            call: Call<List<QuestnItem>?>,
//            response: Response<List<QuestnItem>?>
//        ) {
//            println(response)
//            val responseBody = response.body()!!
//            data = responseBody
////            println(data)
//        }
//
//        override fun onFailure(call: Call<List<QuestnItem>?>, t: Throwable) {
//            println("API call gives error: "+t.message)
//            Log.d("API call for questions", "on Failure: " + t.message)
//        }
//    })
    var aaa = retrofitData
    if(aaa!=null){
        return aaa
    }else{
        return emptyList()
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun getQuestions_a() = GlobalScope.async {
    return@async getQuestData()
}



@OptIn(DelicateCoroutinesApi::class)
suspend fun getQuestions_b() =
    withContext(Dispatchers.Default) {
        return@withContext getQuestData()
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