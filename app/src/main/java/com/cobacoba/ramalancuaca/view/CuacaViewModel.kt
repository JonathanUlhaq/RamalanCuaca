package com.cobacoba.ramalancuaca.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cobacoba.ramalancuaca.models.CuacaModel
import com.cobacoba.ramalancuaca.repositories.CuacaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CuacaViewModel @Inject constructor(private val repo:CuacaRepository):ViewModel() {
    private val _uiState = MutableStateFlow(CuacaModel())
    val uiState = _uiState.asStateFlow()

    fun getCuaca() =
        viewModelScope.launch {
            try {
                _uiState.value = repo.getCuaca()
            } catch (e:Exception) {
                Log.e("Error get cuaca", e.toString())
            }
        }

    init {
        getCuaca()
    }
}