package com.softwareonpurpose.gauntlet.uidriver;

import com.softwareonpurpose.uinavigator.DriverInstantiation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverInstantiation extends DriverInstantiation {
    private static final String HOST_NAME = "chrome";

    private ChromeDriverInstantiation() {
    }

    public static DriverInstantiation getInstance() {
        return new ChromeDriverInstantiation();
    }

    protected ChromeDriver instantiateDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }

    protected void configureDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(getConfig().getTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public String getHostName() {
        return "chrome";
    }
}