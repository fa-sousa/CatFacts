package com.fatimasousa.catfacts.service

import com.fatimasousa.catfacts.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val baseUrl = "https://cat-fact.herokuapp.com/"

    val retrofitClient: Retrofit.Builder by lazy {

        val levelType: Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = Level.BODY else levelType = Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)

        Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
                .build()
                .create(ApiInterface::class.java)
    }
}








//class RetrofitClient private constructor() {
//
//    companion object {
//
//        private lateinit var retrofit: Retrofit
//        private val baseUrl = "https://cat-fact.herokuapp.com/"
//
//        private fun getRetrofitInstance(): Retrofit {
//            val httpClient = OkHttpClient.Builder()
//            if (!::retrofit.isInitialized) {
//
//                retrofit = Retrofit.Builder()
//                        .baseUrl(baseUrl)
//                        .client(httpClient.build())
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build()
//            }
//                return retrofit
//        }
//
//        fun <S> createService(serviceClass: Class<S>): S {
//            return getRetrofitInstance().create(serviceClass)
//
//        }
//    }
//}