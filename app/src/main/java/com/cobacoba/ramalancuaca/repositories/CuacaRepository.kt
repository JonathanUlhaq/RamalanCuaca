package com.cobacoba.ramalancuaca.repositories

import com.cobacoba.ramalancuaca.models.CuacaModel
import com.cobacoba.ramalancuaca.network.WeatherAPI
import javax.inject.Inject

class CuacaRepository @Inject constructor(private val api:WeatherAPI) {
    suspend fun getCuaca():CuacaModel = api.getCuaca()
}