package com.compile.spg.state

import com.compile.spg.StateMachine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import java.lang.System.exit

@Service
class Convolution : State {
    lateinit var env: Environment
        @Autowired set

    override fun doWork(stateMachine: StateMachine) {
        println("convolution")
        exit(0)
    }
}