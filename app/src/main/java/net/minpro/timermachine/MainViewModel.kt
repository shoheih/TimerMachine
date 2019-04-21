package net.minpro.timermachine

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel: ViewModel() {

    var currentYear = MutableLiveData<Int>()
    var displayYear = MutableLiveData<String>()
    var currentTime = MutableLiveData<Int>()
    var displayTime = MutableLiveData<String>()

    lateinit var timerCountDown: Timer


    fun initParameters() {
        currentYear.value = 2019
        displayYear.value = currentYear.value.toString()
        currentTime.value = 10
        displayTime.value = currentTime.value.toString()
    }

    fun countDownStart() {
        timerCountDown = Timer()
        timerCountDown.schedule(1000, 1000) {
            if (currentTime.value!! > 0) {
                val tempTime = currentTime.value!! - 1
                currentTime.postValue(tempTime)
                displayTime.postValue(tempTime.toString())
            } else {
                countDownFinish()
            }
        }
    }

    private fun countDownFinish() {
        timerCountDown.cancel()
    }
}