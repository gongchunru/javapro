package com.gcr.dopdf.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by gongchunru
 * Date：2017/9/27.
 * Time：16:04
 */

public class GlobalConfig {

    public static Properties properties = null;

    public static String readProperty(String propertyName){
        if (properties == null){
            properties = loadProperties();
        }

        assert properties != null;

        return properties.getProperty(propertyName);
    }

    private static Properties loadProperties(){
        Properties properties = new Properties();
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream("config/form.properties");
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}
