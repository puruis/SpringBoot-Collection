package com.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

/**
 * Description:
 * User: purui_zhang
 * Date: 2019-02-20
 * Time: 17:53
 */
@RestController
public class UserController {

    @GetMapping(value = "getUser")
    public Object getUser(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","王大锤");
        map.put("age","22");
        return map;
    }
}
