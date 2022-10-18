package util.parallelRunning;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Mobile implements WebDriverProvider {
//    @Nonnull
//    @Override
//    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
//        Map<String, String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "Nexus 5");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//        chromeOptions.merge(capabilities);
//        return new ChromeDriver(chromeOptions);
//    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
//        browser.setVersion( "96.0");

        browser.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.merge(capabilities);

        browser.merge(chromeOptions);
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    browser            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        WebDriver driver = new ChromeDriver(browser);
//        Configuration.browser = MyWebdriverProvider.class.getName();
        return driver;
    }
}