package com.example.demo;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class HelloWorldController {

    @RequestMapping(value="/all")
    public String helloworld() {
        return "hello world";
    }

    @GetMapping(value = "/data", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ResponseBody
    public Observable<ResponseEntity<?>> getData() {
        return Observable.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new MyData() {
            {
                setName("zhoubing");
            }
        }));
    }

    @GetMapping(value = "/data1")
    @ResponseBody
    public Observable<String> getData1() {
        // 创建并返回一个Single对象
        return Observable.just("data1");
    }
}
