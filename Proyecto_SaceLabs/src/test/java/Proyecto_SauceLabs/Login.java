package Proyecto_SauceLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;
    By usuario= By.xpath("//input[@id='user-name']");
    By contraseña = By.xpath("//input[contains(@id,'password')]");
    By login = By.xpath("//input[contains(@id,'login-button')]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String username) {
        driver.findElement(usuario).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(contraseña).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(login).click();
    }
}
