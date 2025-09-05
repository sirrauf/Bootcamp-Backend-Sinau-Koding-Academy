package com.latihanbootcamp_springboot_helloworld_hari2.latihanbootcamp_springboot_helloworld_hari2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String helloworld(){
        return "Hello Wolrd";


    }

}
