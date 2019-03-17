package com.compile.spg.state

import com.compile.spg.StateMachine
import org.springframework.stereotype.Service
import java.lang.System.exit

@Service
class EndSuccess : State {
    override fun doWork(stateMachine: StateMachine) {
        println("success")
        exit(0)
    }
}