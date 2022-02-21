package me.gary.test

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KotlinApplication{
    companion object{
        @JvmStatic
        fun main(args:Array<String>){
            runApplication<KotlinApplication>(*args)
            println("start success!")
        }
    }
}

