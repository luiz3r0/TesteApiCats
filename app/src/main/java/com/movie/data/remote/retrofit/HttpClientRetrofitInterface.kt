package com.movie.data.remote.retrofit

interface HttpClientRetrofitInterface {

    fun <T> startRetrofit(serviceClass: Class<T>): T
}
