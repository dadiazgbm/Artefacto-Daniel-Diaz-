package Proyecto_SauceLabs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {
    WebDriver driver;
    Login login;

    @BeforeClass
    public void setup() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("128");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-diazd525-119ac");
        sauceOptions.put("accessKey", "b3713ff4-fcc2-4021-ba3e-feb0c2bcadb2");
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<Test Artefacto Daniel Diaz>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        try {
            // Start the session
            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
            driver.get("https://www.saucedemo.com/");

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testLogin() throws InterruptedException {

        login = new Login(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");

        Thread.sleep(5000);
        login.clickLoginButton();
        Thread.sleep(10000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
