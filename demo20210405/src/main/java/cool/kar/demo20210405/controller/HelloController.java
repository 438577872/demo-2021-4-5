package cool.kar.demo20210405.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//你下面的这个类是Controller类  用来返回页面的
public class HelloController {


    @RequestMapping("/")
    public String hello() {
        return "hello world";
    }




}
