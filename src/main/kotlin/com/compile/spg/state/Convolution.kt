package com.compile.spg.state

import com.compile.spg.CharMatrix
import com.compile.spg.CharMatrix.Companion.GREAT
import com.compile.spg.CharMatrix.Companion.LESS
import com.compile.spg.Spg.Companion.MARKER
import com.compile.spg.StateMachine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Service
class Convolution : State {
    lateinit var env: Environment
        @Autowired set
    lateinit var charMatrix: CharMatrix
        @Autowired set
    lateinit var shiftState: State
        @Autowired @Qualifier("shift") set
    lateinit var endSuccessState: State
        @Autowired @Qualifier("endSuccess") set
    lateinit var endErrorState: State
        @Autowired @Qualifier("endError") set

    override fun doWork(stateMachine: StateMachine) {
        val stack = stateMachine.stack
        run loop@{
            stack.reversed().forEachIndexed { i, c ->
                run {
                    if (stack.length != i && charMatrix.getByIndex(c, stack.last()) == LESS) {
                        val property = env.getProperty(stack.substring(stack.length - i))
                        if (property != null) {
                            stateMachine.stack = "${stack.substring(0, stack.length - i)}$property"
                            println(stateMachine.stack)
                            return@loop
                        } else {
                            stateMachine.state = endErrorState
                        }
                    }
                }
            }
        }
        if (charMatrix.getByIndex(stateMachine.stack.last(), stateMachine.phrase.first()) != GREAT) {
            stateMachine.state = shiftState
        }

        if ("${MARKER}S" == stateMachine.stack) {
            stateMachine.state = endSuccessState
        }
    }
}