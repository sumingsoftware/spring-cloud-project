package com.huawei.imc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
// @EnableHystrixDashboard
@EnableCircuitBreaker
public class LoginController {
	@Autowired
	    private HelloService helloService;

		@RequestMapping("/hello")
	    public String hello(@RequestParam("name")String name){
	        return helloService.hello(name);
	    }   

		@Value("${name}")
	    private  String name;   
		@Value("${age}")
	    private  String age;   
		@Value("${version}")
	    private  String version="开发环境";

		   

		@RequestMapping("/test")
	    public String test(){
	        return "你好，我是"+name+",年龄："+age+"岁。当前环境："+version;
	    }
	

	
}
