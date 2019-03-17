package com.compile.spg.state

import com.compile.spg.CharMatrix
import com.compile.spg.CharMatrix.Companion.GREAT
import com.compile.spg.StateMachine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
open class Shift : State {
    lateinit var convolutionState: State
        @Autowired @Qualifier("convolution") set

    lateinit var charMatrix: CharMatrix
        @Autowired set

    override fun doWork(stateMachine: StateMachine) {
        val stack = stateMachine.stack
        val phrase = stateMachine.phrase
        stateMachine.stack = "$stack${phrase.first()}"
        stateMachine.phrase = phrase.substring(1, phrase.length - 1)

        println(stateMachine.stack)

        if (charMatrix.getByIndex(stateMachine.stack.last(), stateMachine.phrase.first()) == GREAT) {
            stateMachine.state = convolutionState
        }
    }
}