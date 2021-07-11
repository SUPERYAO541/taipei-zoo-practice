package com.superyao.taipeizoo.architecture.main.pavilion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superyao.taipeizoo.model.Pavilion
import com.superyao.taipeizoo.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PavilionViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {

    val pavilions = MutableLiveData<List<Pavilion>>()

    fun refreshPavilions(query: String = "") {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getPavilions(query)
            pavilions.postValue(data)
        }
    }
}