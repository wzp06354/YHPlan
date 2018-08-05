package com.wozipa.www.project.yhplan.cookie;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.wozipa.www.project.yhplan.tess4j.ValidCodeParse;
import org.apache.log4j.Logger;

import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wozipa on 18-6-26.
 */
public class CookieCacheManager {

    public static final Logger LOGGER = Logger.getLogger(CookieCacheManager.class);

    public static volatile CookieCacheManager INSTANCE = null;

    public static CookieCacheManager GetInstance() {
        if (INSTANCE == null) {
            synchronized (CookieCacheManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CookieCacheManager();
                }
            }
        }
        return INSTANCE;
    }

    private WebClient webClient = null;

    private CookieCacheManager(){
        String username = "Wozipa";
        String password = "wzp931577";
        WebClient webClient=new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setTimeout(10000);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setRedirectEnabled(true);
        try {
            String loginHtml = "http://i8wj.yhyl357.com/login.html";
            HtmlPage page=webClient.getPage(loginHtml);
            webClient.waitForBackgroundJavaScript(10000);
            webClient.setJavaScriptTimeout(0);
            //
            page.getElementById("userName").setNodeValue("Wozipa");
            page.getElementById("password").setNodeValue("wzp931577");
            HtmlImage validImg = (HtmlImage) page.getElementById("validate");
            String validCode = getValidCode(validImg);
            System.out.println(validCode);
            page.getElementById("code").setNodeValue(validCode);

            WebResponse response=page.getElementById("submit").click().getWebResponse();
            //
            WebRequest request = new WebRequest(new URL("http://i8wj.yhyl357.com/ct-data/loadOpenCode"));
            request.setHttpMethod(HttpMethod.POST);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new NameValuePair("shortName","xdlxyssc"));
            params.add(new NameValuePair("expect","20180715901"));
            request.setRequestParameters(params);
            Page page1 = webClient.getPage(request);
            System.out.println(page1.getWebResponse().getContentAsString());
            this.webClient = webClient;
        } catch (FailingHttpStatusCodeException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public String getValidCode(HtmlImage image){
        File img = new File("/home/wozipa/Test/yh/code.png");
        String validCode = null;
        try {
            image.saveAs(img);
            ValidCodeParse parser = new ValidCodeParse("/home/wozipa/Test/yh","code.png");
            parser.parse();
            validCode = parser.getValidCode();
            return validCode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return validCode;
    }


    public WebClient getWebClient(){
        return this.webClient;
    }


}
