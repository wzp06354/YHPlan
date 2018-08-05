package com.wozipa.www.project.yhplan.cache;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wozipa on 18-7-15.
 */
public class XDLResultCache {

    private static final Logger LOGGER = Logger.getLogger(XDLResultCache.class);

    private static volatile XDLResultCache INSTANCE = null;

    public static XDLResultCache getInstance(){
        if(INSTANCE ==  null){
            synchronized (XDLResultCache.class){
                if(INSTANCE == null){
                    INSTANCE = new XDLResultCache();
                }
            }
        }
        return INSTANCE;
    }

    private XDLResultCache(){
        this.cache = new HashMap<>();
    }

    private Map<String,String> cache = null;

    public synchronized void addResultCode(String time,String code){
        this.cache.put(time,code);
    }

    public synchronized String getResultCode(String time){
        if(this.cache.containsKey(time)){
            return this.cache.get(time);
        }
        else return null;
    }
}
