package by.bsu.automation.tests;

import by.bsu.automation.utils.ConfigurationValues;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by kateverbitskaya on 20.12.2015.
 */
public class SearchTest {

    private static Logger logger = Logger.getLogger(SearchTest.class);

    private final By buttonSignInLocator = By.xpath("//a[text()=' — Википедия']");

    @Test
    public void testOneSearchYandex() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConfigurationValues.AUTO);
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("Сирия");
        driver.findElement(By.xpath("//button[@class='button suggest2-form__button button_theme_websearch button_size_m i-bem button_js_inited']")).click();
        driver.findElement(buttonSignInLocator).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info("Go to wikipedia");
        driver.quit();
    }
}
