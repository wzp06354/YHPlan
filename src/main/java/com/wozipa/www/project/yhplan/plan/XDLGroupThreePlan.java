package com.wozipa.www.project.yhplan.plan;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.wozipa.www.project.yhplan.cookie.CookieCacheManager;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by wozipa on 18-7-1.
 */
public class XDLGroupThreePlan {

    private static final Logger LOGGER = Logger.getLogger(XDLGroupSixPlan.class);


    private String id = null;
    private String url = null;
    private int addCycle = 0;
    private int timeCycle = 0;

    private HtmlPage page = null;

    public void openPage(){
//        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setTimeout(10000);
//        webClient.getCookieManager().setCookiesEnabled(true);
//        webClient.setCookieManager(CookieCacheManager.GetInstance().getCookieManager());
//        //
//        try {
//            HtmlPage page = webClient.getPage(this.url);
//            page.getElementById("");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
