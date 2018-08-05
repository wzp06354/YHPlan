package com.wozipa.www.project.yhplan.cache;

import org.apache.log4j.Logger;

/**
 * Created by wozipa on 18-7-1.
 */
public class OpenCodeCache {

    private static final Logger LOGGER = Logger.getLogger(OpenCodeCache.class);

    private volatile static OpenCodeCache INSTANCE = null;

    public static OpenCodeCache GetInstance(){
        if(INSTANCE == null){
            synchronized (OpenCodeCache.class){
                if(INSTANCE == null){
                    INSTANCE = new OpenCodeCache();
                }
            }
        }
        return INSTANCE;
    }

    private OpenCodeCache(){}

    
}
