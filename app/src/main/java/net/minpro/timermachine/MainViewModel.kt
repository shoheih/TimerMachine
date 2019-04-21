package net.minpro.timermachine

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var currentYear = MutableLiveData<Int>()
    var displayYear = MutableLiveData<String>()
    var currentTime = MutableLiveData<Int>()
    var displayTime = MutableLiveData<String>()


    fun initParameters() {
        currentYear.value = 2019
        displayYear.value = currentYear.value.toString()
        currentTime.value = 60 * 60
        displayTime.value = currentTime.value.toString()
    }
}