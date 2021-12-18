package com.dell.Utilities;


import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class DriverHandler {


    private static Platform platform;
    ChromeDriver driver;

    //Setting WebDriver/Chrome driver version using WebDriverManager

    private void setWebDriver(Platform platform) {

        switch (platform) {
            case MAC:
                WebDriverManager.chromedriver().operatingSystem(OperatingSystem.MAC).setup();
                break;
            case WINDOWS:
                WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
                break;
            case LINUX:
                WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
                break;
            default:
                System.out.println("WebDriver has not been set! There is a problem!\n");
                break;
        }
    }


    //Get current platform, will use to get correct webdriver version
    public static Platform getCurrentPlatform() {
        if (platform == null) {
            String operatingSystem = System.getProperty("os.name").toLowerCase();
            if (operatingSystem.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")) {
                platform = Platform.LINUX;
            } else if (operatingSystem.contains("mac")) {
                platform = Platform.MAC;
            }
        }
        return platform;
    }

    public ChromeDriver createDriver() throws IOException {
        ChromeOptions options = new ChromeOptions();
        setWebDriver(getCurrentPlatform());

        options.addArguments("--incognito");
        options.addArguments("--window-size=1024,768");

        driver  = new ChromeDriver(options);
        return driver;

    }
}
