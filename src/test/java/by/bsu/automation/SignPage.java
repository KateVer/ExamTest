package by.bsu.automation;

import by.bsu.automation.utils.ConfigurationValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignPage {

//    private final By inputLink = By.xpath("//a[@class='link nav__link link__control i-bem link_js_inited']");

  //  private final By inputLink = By.xpath("//a[text()='Войти']");

    private final By inputLogin = By.xpath("//input[@name='login']");


    private final By inputPassword = By.xpath("//input[@name='passwd']");

    private final By inputButton = By.xpath("//button");

    public WebDriver signIn() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConfigurationValues.AUTO);
       // driver.findElement(inputLink).click();
        driver.findElement(inputLogin).sendKeys(ConfigurationValues.AUTO_USERNAME);
        driver.findElement(inputPassword).sendKeys(ConfigurationValues.AUTO_PASSWORD);
        driver.findElement(inputButton).click();
        return driver;
    }
}
