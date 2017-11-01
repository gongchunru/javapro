package com.gcr.dopdf.services;

import org.springframework.stereotype.Service;

/**
 * Created by gongchunru
 * Date：2017/9/27.
 * Time：16:16
 */
@Service("dataService")
public class DataService {
    public String sayHello(String someone){
        return "hello "+someone;
    }
}
