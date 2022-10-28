package com.mainuddin.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloworld(){
        return "Hello World";
    }


    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("hello world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloworldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("hello world, %s",name));
    }

    @GetMapping(path = "/hello-world-internationalized/{username}")
    public String helloWorldInternationalized(@PathVariable String username){
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale);
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale) + username;
    }
}
