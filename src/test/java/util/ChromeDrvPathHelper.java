package util;

import java.io.File;

public class ChromeDrvPathHelper {
    public static void setChromeDrvPath(){
        //CHANGE PATH TO THE CHROMEDRIVER AS NEEDED - AND RE-RUN TESTS
        String osName = System.getProperty("os.name");
        String silnikChrome = "src"+ File.separator + "test" + File.separator + "java"+ File.separator + "resources" + File.separator + "chromedriver";
        if(osName.startsWith("Win")) {
            silnikChrome = silnikChrome + ".exe";
        }
        System.setProperty("webdriver.chrome.driver", silnikChrome);
    }



}
