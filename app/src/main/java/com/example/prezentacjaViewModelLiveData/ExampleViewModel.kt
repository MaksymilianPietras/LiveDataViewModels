package com.example.prezentacjaViewModelLiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ExampleViewModel : ViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String> get() = _text

    private val _counter = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _counter

    val message = MutableLiveData<String>()

    init {
        _text.value = "LiveData: 0"
        _counter.value = 0
    }

    fun updateText(newText: String) {
        _text.value = newText
    }

    fun increaseCounter(){
        _counter.value = _counter.value!! + 1
    }
}