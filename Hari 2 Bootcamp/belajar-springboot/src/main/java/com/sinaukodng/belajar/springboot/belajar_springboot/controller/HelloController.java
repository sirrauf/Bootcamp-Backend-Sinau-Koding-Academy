package com.sinaukodng.belajar.springboot.belajar_springboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello-world")
public class HelloController {

    @GetMapping()
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("say-hello")
    public String sayHello(@RequestParam String nama) {
        return "Hello " + nama;
    }

    @GetMapping("say-hello/{nama}")
    public String sayHelloPath(@PathVariable String nama) {
        return "Hello " + nama;
    }
}
