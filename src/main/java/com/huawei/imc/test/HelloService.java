package com.huawei.imc.test;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@EnableFeignClients
@FeignClient(value = "helloService", fallback = HelloError.class)
public interface HelloService {
	       
@RequestMapping(value = "/hello", method = RequestMethod.GET)
        String hello(@RequestParam("name") String name);
}   

@Component
   public class HelloError implements HelloService {
	       
	@Override
        public String hello(String name){
            return "hello  ,"+name+"!  sorry ,error !";
        }   
}}
