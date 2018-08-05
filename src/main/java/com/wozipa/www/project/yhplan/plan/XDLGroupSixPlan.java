package com.wozipa.www.project.yhplan.plan;


import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.wozipa.www.project.yhplan.cache.XDLResultCache;
import com.wozipa.www.project.yhplan.cookie.CookieCacheManager;
import com.wozipa.www.project.yhplan.enums.Positions;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wozipa on 18-7-1.
 */
public class XDLGroupSixPlan extends Thread{

    private static final Logger LOGGER = Logger.getLogger(XDLGroupSixPlan.class);


    private String id = null;
    private String name = null;
    private String date = null;
    private int period = 0;
    private String url = null;
    private int waitCycle = 0;
    private int addCycle = 0;
    private Positions position = null;

    private WebClient webClient = null;
    private HtmlPage page = null;
    private int[] lottes = new int[]{1,2,4,5,10,20,40,50,100,200,400,500};
    private int lotteyIndex = 0;

    public XDLGroupSixPlan(String id,String url,Positions position,int waitCycle,int addCycle){
        this.id = id;
        this.name = "xdlxyssc";
        this.date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        this.period = 0;
        this.url = url;
        this.position = position;
        this.waitCycle = waitCycle;
        this.addCycle = addCycle;
        initlize();
    }

    public String getGroupSixClassName(Positions position){
        switch (position) {
            case FrontThree:return "sxzuxzlq";
            case MiddleThree:return "sxzuxzlz";
            case BehindThree:return "sxzuxzlh";
        }
        return "";
    }

    private void initlize(){
        System.out.println("Initlize the page");
        this.webClient = CookieCacheManager.GetInstance().getWebClient();
    }


    @Override
    public void run() {
//        initlize();
        try {
            String result = getResultAndCache();
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResultAndCache() throws IOException {
        WebRequest request = new WebRequest(new URL("http://i8wj.yhyl357.com/ct-data/loadOpenCode"));
        request.setHttpMethod(HttpMethod.POST);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("shortName",this.name));
        params.add(new NameValuePair("expect",this.date));
        request.setRequestParameters(params);
        Page page = webClient.getPage(request);
        System.out.println(page.getWebResponse().getContentAsString());
        return "";
    }

    public void doOrder() throws IOException {
        DomElement container = this.page.getElementById(getGroupSixClassName(position));
        DomNodeList<HtmlElement> lis = container.getElementsByTagName("li");
        for(HtmlElement li : lis){
            if(li.getAttribute("class" ) ==  getGroupSixClassName(position) + "_zu_ful_0-9"){
                li.click();
            }
        }
        //　选择指定的两个数字
        int[] nums = getLastTwoNumber();
        for(int num :nums){
            for(HtmlElement li : lis){
                if(li.getAttribute("class") == getGroupSixClassName(position) + "_zu_" + nums[num]){
                    li.click();
                }
            }
        }
        //
        DomNodeList<HtmlSelect> selects = this.page.getElementByName("select");
        for(HtmlSelect select:selects){
            if(select.getAttribute("class" ) == "ym-fbox-select"){
                List<HtmlOption> options = select.getOptions();
                for(HtmlOption option : options){
                    if(option.getNodeValue()=="0.001" || option.getNodeValue() == "厘"){
                        option.click();
                    }
                }
            }
        }
        // 设置金额
        HtmlInput input = (HtmlInput) this.page.getElementById("lotteryTimes");
        input.setTextContent(Integer.toString(lottes[lotteyIndex]));
        // 进行订单提交
        this.page.getElementById("fastOrder").click();
        DomNodeList<HtmlElement> as = this.page.getElementById("qrtouzhu").getElementsByTagName("a");
        for(HtmlElement a :as){
            if(a.getNodeValue() == "确认" && a.getAttribute("href") == "javascript:Lottery_Rule.pre_buyBtn();"){
                a.click();
            }
        }
    }


    public int[] getLastTwoNumber(){
        int[] nums = new int[2];
        return null;
    }



}
