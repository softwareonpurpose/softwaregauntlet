package org.softwareonpurpose.gauntlet;

import com.softwareonpurpose.uinavigator.UiDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsUiDriver extends UiDriver {
    private SauceLabsUiDriver() {
    }

    public static SauceLabsUiDriver getInstance() {
        return new SauceLabsUiDriver();
    }

    @Override
    public WebDriver instantiateDriver() {
        DesiredCapabilities capabilities;
        MutableCapabilities sauceOptions = new MutableCapabilities();
        String capturePerf = System.getProperty("capturePerf", "false");
        sauceOptions.setCapability("username", "[UserName]");
        sauceOptions.setCapability("accessKey", "[Password]");
        sauceOptions.setCapability("seleniumVersion", "3.141.59");
        sauceOptions.setCapability("name", "CraigsTest");
        sauceOptions.setCapability("recordScreenshots", "true");
        sauceOptions.setCapability("recordVideo", "true");
        sauceOptions.setCapability("screenResolution", "1920x1080");
        sauceOptions.setCapability("build", "testBuild");
        sauceOptions.setCapability("idleTimeout", "1000");
        if (capturePerf.equalsIgnoreCase("true")) {
            sauceOptions.setCapability("extendedDebugging", true); // Enable debugging perf
            sauceOptions.setCapability("capturePerformance", true); // Capture page load perf
        }
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setJavascriptEnabled(true);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    new URL("https://" + "[UserName]" + ":" + "[Password]" + "@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public void configureDriver(WebDriver webDriver) {

    }

    @Override
    public String getHostName() {
        return null;
    }
}
