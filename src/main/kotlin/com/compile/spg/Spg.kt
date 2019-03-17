package com.compile.spg

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Spg {
    lateinit var stateMachine: StateMachine
        @Autowired set

    fun start() {
        print("Enter phrase: ")
        val phrase = readLine()!!

        stateMachine.phrase = phrase
        while (true) {
            stateMachine.doWork()
        }
    }

    companion object {
        const val MARKER = '#'
    }
}