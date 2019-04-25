package net.minpro.timermachine.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import net.minpro.timermachine.model.UserSettings
import net.minpro.timermachine.model.UserSettingsRepository
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel: ViewModel() {

    var currentYear = MutableLiveData<String>()
    var displayYear = MutableLiveData<String>()
    var currentTime = MutableLiveData<Int>()
    var displayTime = MutableLiveData<String>()

    private val userSettingsRepository = UserSettingsRepository()
    private lateinit var userSettings: UserSettings

    lateinit var timerCountDown: Timer

    fun initParameters() {
        userSettings = userSettingsRepository.loadUserSettings()
        currentYear.value = userSettings.themeName
        displayYear.value = userSettings.themeName
        currentTime.value = 3 * 60
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

    fun setTheme(selectedItemId: Int) {
        displayYear.value = userSettingsRepository.setTheme(selectedItemId)
        Log.d("female", displayYear.value)
    }
}