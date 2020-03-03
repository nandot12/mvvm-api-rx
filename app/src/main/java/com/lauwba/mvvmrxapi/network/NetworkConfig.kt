package com.lauwba.mvvmrxapi.network

import com.lauwba.mvvmrxapi.model.ModelResponse
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.math.log

class NetworkConfig {



    companion object{


        fun getInterceptor():OkHttpClient{

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            return  OkHttpClient.Builder().addInterceptor(logging)
                .build()
        }

        fun getRetrofit():Retrofit{

            return Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        fun ApiService() = getRetrofit().create(ApiService::class.java)
    }
}

interface ApiService {


    @GET("everything?q=bali&from=2020-02-03&sortBy=publishedAt&apiKey=d32dd7d06e3b40b8ab47fb94dfbe8ac4")
    fun getNews():Flowable<ModelResponse>

}