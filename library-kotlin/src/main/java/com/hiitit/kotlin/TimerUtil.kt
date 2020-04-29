package com.hiitit.kotlin

import kotlin.concurrent.fixedRateTimer

object TimerUtil {
    fun timer(name: String = "default", length: Int, period: Long = 1000, onUpdate: () -> Unit) {
        var counter = 0
        fixedRateTimer(name, false, 0L, period) {
            counter++
            onUpdate()
            if (counter >= length) this.cancel()
        }
    }
}
