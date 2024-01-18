package com.aocheretyabyi.data.network

import okhttp3.Interceptor
import okhttp3.Response

class SimpleInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.let {
            val response = it.proceed(it.request())
            println(response.toString())
            return@let response
        }

}