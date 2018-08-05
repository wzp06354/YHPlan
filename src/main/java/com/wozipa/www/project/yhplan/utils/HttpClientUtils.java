package com.wozipa.www.project.yhplan.utils;

import com.gargoylesoftware.htmlunit.util.Cookie;
import com.wozipa.www.project.yhplan.cookie.CookieCacheManager;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by wozipa on 18-7-15.
 */
public class HttpClientUtils {

    private static final Logger LOGGER = Logger.getLogger(HttpClientUtils.class);

    public void sendPost(String url,Map<String,String> params){
        HttpPost post = new HttpPost();
    }
}
