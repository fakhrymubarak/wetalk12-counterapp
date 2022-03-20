package com.fakhry.wetalk12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var counter = 0
    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int> = _number

    fun increaseNumber() {
        counter++
        _number.postValue(counter)
    }

    fun decreaseNumber(){
        counter--
        _number.postValue(counter)
    }
}