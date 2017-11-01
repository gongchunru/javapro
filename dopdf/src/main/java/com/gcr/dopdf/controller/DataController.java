package com.gcr.dopdf.controller;

import com.gcr.dopdf.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gongchunru
 * Date：2017/9/27.
 * Time：17:01
 */
@RestController
@RequestMapping(value = "data")
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "")
    public Map index(){
        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("status",true);
        resultMap.put("code","data");
        resultMap.put("message","data");
        return resultMap;
    }

    @RequestMapping(value = "hello/{someone:.+}")
    public Map sayHello(@PathVariable String someone){
        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("status",true);
        resultMap.put("code",someone);
        resultMap.put("message",dataService.sayHello(someone));
        return resultMap;
    }
}
