package com.team.whackamole.ui.viewmodels

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel(

): ViewModel() {

    val timerValue = MutableLiveData<String>()

    init {
        startTimer()
    }

    private fun startTimer() {
        object : CountDownTimer(ONE_MINUTE, ONE_SECOND) {
            override fun onTick(p0: Long) {
                timerValue.value = SPACE + (p0 / 1000).toString() + SPACE + SEC
            }

            override fun onFinish() {
                timerValue.value = EMPTY_STRING
            }
        }.start()
    }

    companion object {
        const val SPACE = " "
        const val SEC = "сек"
        const val ONE_MINUTE: Long = 60000
        const val ONE_SECOND: Long = 1000
        const val EMPTY_STRING = ""
    }
}