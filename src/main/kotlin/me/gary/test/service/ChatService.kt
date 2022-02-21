package me.gary.test.service

import java.util.concurrent.ConcurrentHashMap
import me.gary.test.service.ChatService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.lang.InterruptedException

/**
 * @Classname ChatService
 * @Description TODO
 * @Date 2022/2/21 15:12
 * @Auth gary
 */
@Service
class ChatService {
    companion object {
        val map = mapOf<Int,String>(1 to "haha",2 to "xixi",3 to "lele")
    }

    fun get(integer: Int): String? {
        val s = map[integer]
        println(s)
        return s
    }

    fun get2(integer: Int): String? {
        val s = map[integer]
        println(s)
        return s
    }



    fun getAll():Flux<String?>{
       return Flux.create { sink: FluxSink<String?> ->
            map.forEach { (integer: Int?, s: String?) ->
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                println(s)
                sink.next(s)
            }
        }
    }
}