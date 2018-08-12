package com.mmall.util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
/**
 * Created by xujiqing on 2018/6/24.
 */
public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;

    /**
     * 我们写一个PropertiesUtil的实现,这个实现需要tomcat启动的时候就要读取它的配置
     * 所以这里我们会使用一个静态块来解决这类问题
     * 静态块本身的执行顺序是优于普通代码块，普通代码块优于构造代码块
     * static代码块会在类加载的时候执行且仅执行一次，一般用它做初始化静态变量
     */
    static {
        String fileName = "mmall.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }

    public static String getProperty(String key){
        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){

        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }
}
