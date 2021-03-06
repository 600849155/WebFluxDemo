package com.whohim.wf.controller;

import com.whohim.wf.helper.ErrorHandler;
import com.whohim.wf.model.demo;
import com.whohim.wf.result.Response;
import com.whohim.wf.service.FluxQueryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author WhomHim
 * @date Create in 2020-4-5 12:32:56
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/")
@Slf4j
public class HelloController {

    FluxQueryService fluxQueryService;

    ErrorHandler errorHandler;

    @GetMapping("mono")
    public Mono<String> mono() {
        return Mono.just("hello webflux!");
    }

    @GetMapping("mono2")
    public Mono<Object> objectMono() {
        return Mono.create(objectMonoSink -> {
            log.info("mono create");
            objectMonoSink.success("hello webflux");
        })
                .doOnSubscribe(subscription -> {
                    log.info("{}", subscription);
                })
                .doOnNext(o -> log.info("{}", o));

    }

    @GetMapping("flux")
    public Flux<String> flux() {
        return Flux.just("hello", "webflux", "spring", "boot");
    }

    @GetMapping("test")
    public Mono<Response<demo>> test() {
        return Mono.just("")
                .map(obj -> fluxQueryService.getUser())
                .map(Response::success)
                .doOnError(errorHandler::handleFlowResponseException);
    }

    @GetMapping("test2")
    public Mono<Response<String>> test2() {
        return Mono.just("")
                .map(obj -> fluxQueryService.getHello())
                .map(Response::success)
                .doOnError(errorHandler::handleFlowResponseException);
    }

    public static void main(String[] args) {
        Flux.just("tom", "jack", "allen")
                .map(s -> s.concat("@qq.com"))
                .subscribe(System.out::println);
    }
}
