package com.compile.spg.state

import com.compile.spg.StateMachine

interface State {
    fun doWork(stateMachine: StateMachine)
}