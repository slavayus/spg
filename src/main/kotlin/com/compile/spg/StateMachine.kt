package com.compile.spg

import com.compile.spg.state.State
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
open class StateMachine(@Qualifier("shift") var state: State) {
    lateinit var shiftState: State
        @Autowired @Qualifier("shift") set
    lateinit var convolutionState: State
        @Autowired @Qualifier("convolution") set
    var phrase = ""
        set(value) {
            field = "$value#"
        }
    var stack = "#"

    fun doWork() {
        state.doWork(this)
    }
}