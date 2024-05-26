package org.example;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.HashMap;

public class Main2 {
    static HashMap<String, String> hashMap = new HashMap<>();

    public static void function(String city_name, String day){

        final WebClient web = new WebClient(BrowserVersion.CHROME);

        try {
            web.getOptions().setCssEnabled(false);
            web.getOptions().setThrowExceptionOnFailingStatusCode(false);
            web.getOptions().setThrowExceptionOnScriptError(false);
            web.getOptions().setPrintContentOnFailingStatusCode(false);

            HtmlPage page = web.getPage("https://www.google.com/search?q=" + city_name + "+weather+" + day + "&rlz=1C1VDKB_enPK1023PK1023&sxsrf=ALiCzsar79XDyp2hdO6kJPe9YOhiejTNag%3A1671633687497&ei=FxujY4f1HfWL9u8P2NC4-A8&oq=" + city_name + "+weather+we&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgcIIxAnEJ0CMgUIABCABDIKCAAQgAQQhwIQFDIFCAAQgAQyBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yCAgAEBYQHhAKMgUIABCGAzIFCAAQhgM6CggAEEcQ1gQQsAM6BwgAELADEEM6BAgjECc6CwgAEIAEELEDEIMBOgQIABBDOgoIABCxAxCDARBDSgQIQRgASgQIRhgAUPAIWM1LYLdZaARwAXgBgAHRBIgB9wmSAQkyLTEuMS4wLjGYAQCgAQHIAQrAAQE&sclient=gws-wiz-serp");
            hashMap.put("temp", page.getElementById("wob_tm").getVisibleText());
            hashMap.put("precipitation", page.getElementById("wob_pp").getVisibleText());
            hashMap.put("dayAndTime", page.getElementById("wob_dts").getVisibleText());
            hashMap.put("humidity", page.getElementById("wob_hm").getVisibleText());
            hashMap.put("wind", page.getElementById("wob_ws").getVisibleText());
            hashMap.put("description", page.getElementById("wob_dc").getVisibleText());
            hashMap.put("icon", "https:" + page.getElementById("wob_tci").getAttribute("src"));

            web.getCurrentWindow().getJobManager().removeAllJobs();
            web.close();
        } catch (IOException e) {
            System.out.println("Exception caught..." + e.getMessage());
        }
    }
}

