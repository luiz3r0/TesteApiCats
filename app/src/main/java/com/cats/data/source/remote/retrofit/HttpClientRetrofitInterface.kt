package com.cats.data.source.remote.retrofit

interface HttpClientRetrofitInterface {

    fun <T> startRetrofit(serviceClass: Class<T>): T
}
