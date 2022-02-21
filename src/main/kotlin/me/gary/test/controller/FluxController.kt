package me.gary.test.controller


import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import me.gary.test.service.ChatService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Mono
import reactor.core.publisher.MonoSink
import reactor.core.publisher.Flux
import javax.annotation.Resource
import kotlin.math.log

/**
 * @Classname FluxController
 * @Description TODO
 * @Date 2022/2/21 13:33
 * @Auth gary
 */
@RestController
@RequestMapping("/flux")
@Slf4j
class FluxController @Autowired constructor(
   private val chatService: ChatService
)
{
    /**
     * yibu
     * @return
     */
    @GetMapping("/see/{id}")
    fun see(@PathVariable("id") integer: Int?): Mono<String?> {
        println("开始")
        val mono = Mono.create { stringFluxSink: MonoSink<String?> ->
            stringFluxSink.success(
                chatService.get(integer!!)
            )
        }
        println("结束")
        return mono
    }

    /**
     * yibu
     * @return
     */
    @GetMapping(value = ["/getALl"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun see(): Flux<String?> {
        println("---1")
        val all = chatService.getAll()
        println("----2")
        return all
    }
}