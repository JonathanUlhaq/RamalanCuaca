package com.cobacoba.ramalancuaca.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.cobacoba.ramalancuaca.utils.tanggalFormater

@Composable
fun CuacaView(
    viewModel: CuacaViewModel
) {
    val uiState = viewModel.uiState.collectAsState().value

    if (uiState.list != null) {
        Log.d("Weather Forecast","")
        uiState.list.forEach {
            item ->
            Log.d("${tanggalFormater(item.dt!!)}", "${item.temp?.min}ºC")
        }
    }
}