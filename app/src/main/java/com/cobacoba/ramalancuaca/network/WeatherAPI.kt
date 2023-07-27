package com.cobacoba.ramalancuaca.network

import com.cobacoba.ramalancuaca.models.CuacaModel
import com.cobacoba.ramalancuaca.utils.ConstValue
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherAPI {
    @GET("data/2.5/forecast/daily")
    suspend fun getCuaca(
        @Query("q") q: String = ConstValue.CITY,
        @Query("cnt")cnt:Int = ConstValue.COUNTS,
        @Query("appid")appid:String = ConstValue.APP_ID,
        @Query("units")units:String = ConstValue.UNITS
        ):CuacaModel
}