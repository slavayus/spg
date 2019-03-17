package com.compile.spg

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan
@PropertySource("grammar.properties")
open class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val context = AnnotationConfigApplicationContext(Main::class.java)
            context.getBean("spg", Spg::class.java).start()
        }
    }

}

