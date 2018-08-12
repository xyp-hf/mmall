package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by xxx on 2018/6/24.
 * 本地缓存 GUAUA
 */
public class TokenCache {
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static final String TOKEN_PREFIX = "token_";
    /**
     * 声明一个静态的内存块
     * initialCapacity(1000) 设置缓存的初始化容量为1000
     * maximumSize() 缓存的最大容量，当超过这个容量GUAUA的Cache就使用LRU算法，即最少使用算法来移除缓存项，最大值设置成10000
     * expireAfterAccess() 有效期 12个小时
     */
    private static LoadingCache<String,String> localCache =
            CacheBuilder.newBuilder().
            initialCapacity(1000).
            maximumSize(10000).
            expireAfterAccess(12, TimeUnit.HOURS).
            build(new CacheLoader<String, String>() {
                // 默认的数据加载实现,当调用get取值的时候,如果key没有对应的值
                // 就调用这个方法进行加载
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });
    public static void setKey(String key,String value){
        localCache.put(key,value);
    }
    public static String getKey(String key){
        String value = null;
        try{
            value = localCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            logger.error("localCache get error",e);
        }
        return null;
    }
}
