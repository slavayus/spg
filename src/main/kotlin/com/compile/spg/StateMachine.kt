package com.compile.spg

import com.compile.spg.Spg.Companion.MARKER
import com.compile.spg.state.State
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
open class StateMachine(@Qualifier("shift") var state: State) {
    var phrase = ""
        set(value) {
            field = "$value$MARKER"
        }
    var stack = "$MARKER"

    fun doWork() {
        state.doWork(this)
    }
}