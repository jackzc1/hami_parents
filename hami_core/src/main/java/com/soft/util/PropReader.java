package com.soft.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
sys.properties文件读取工具类
*/
public class PropReader {

    public static String sysReader(String key) {
        Properties properties = new Properties();
        InputStream resourceAsStream = PropReader.class.getClassLoader().getResourceAsStream("sys.properties");
        String filePath = null;
        try {
            properties.load(resourceAsStream);
            filePath = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

}
