package com.team.whackamole.ui.viewmodels

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel(

) : ViewModel() {

    val timerValue = mutableStateOf("0")
    val molePosition = MutableLiveData<Int>()
    val isMoleVisible = MutableLiveData<Boolean>()
    val userScore = mutableStateOf(0)
    var isTimerFinish = MutableLiveData<Boolean>()

    init {
        startTimer()
        moveMoleOnRandomPosition()
        showMole()
        userScore.value = 0
    }

    private fun startTimer() {
        object : CountDownTimer(ONE_MINUTE, ONE_SECOND) {
            override fun onTick(p0: Long) {
                timerValue.value = SPACE + (p0 / 1000).toString() + SPACE + SEC

            }

            override fun onFinish() {
                isTimerFinish.value = true
            }
        }.start()
    }

    fun moveMoleOnRandomPosition() {
        viewModelScope.launch {
            val delayValue = (0..5).random() * 1000
            delay(delayValue.toLong())
            molePosition.value = (0..11).random()
            showMole()
        }
    }

    fun upScore() {
        userScore.value = userScore.value?.plus(1)
    }

    fun hideMole() {
        isMoleVisible.value = false
    }

    private fun showMole() {
        isMoleVisible.value = true
    }

    companion object {
        const val SPACE = " "
        const val SEC = "сек"
        const val ONE_MINUTE: Long = 5000
        const val ONE_SECOND: Long = 1000
        const val EMPTY_STRING = ""
    }
}