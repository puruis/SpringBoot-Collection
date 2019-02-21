package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@SpringBootApplication
public class SpringBootSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleApplication.class, args);
	}

	@GetMapping(value = "test")
	public Object test(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("code",0000);
		map.put("msg","获取数据成功");
		return map;
	}
}
