package org.example;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    static HashMap<String, String> hashMap = new HashMap<>();

    public static void function(String city_name){

        final WebClient web = new WebClient(BrowserVersion.CHROME);

        try {
            web.getOptions().setCssEnabled(false);
            web.getOptions().setThrowExceptionOnFailingStatusCode(false);
            web.getOptions().setThrowExceptionOnScriptError(false);
            web.getOptions().setPrintContentOnFailingStatusCode(false);

            HtmlPage page = web.getPage("https://www.google.com/search?q=" + city_name + "+weather&rlz=1C1VDKB_enPK1023PK1023&oq=" + city_name + "&aqs=chrome.0.69i59l3j46i131i433i512j69i60l3j69i64.1806j1j7&sourceid=chrome&ie=UTF-8");
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

