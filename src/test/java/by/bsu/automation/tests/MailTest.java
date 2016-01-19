package by.bsu.automation.tests;

import by.bsu.automation.SignPage;
import by.bsu.automation.utils.ConfigurationValues;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MailTest {

    private static Logger logger = Logger.getLogger(MailTest.class);



    SignPage signPage = new SignPage();

    @Test
    public void testOneCanSendMessage() {
        WebDriver driver = signPage.signIn();
        logger.info("Login in system");

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[@class='b-ico b-ico_compose']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'js-compose-mail-input_to')]//input[1]")).sendKeys(ConfigurationValues.GOOGLE_COM_USERNAME);
        driver.findElement(By.xpath("//input[@name='subj']")).sendKeys("Automation testing");
        driver.findElement(By.xpath("//button[@id='nb-18']")).submit();
        logger.info("Send message to " + ConfigurationValues.GOOGLE_COM_USERNAME);
        driver.quit();

        WebDriver driverr = new FirefoxDriver();

        driverr.get("http://mail.google.com/");
        driverr.findElement(By.xpath("//input[@id='Email']")).sendKeys(ConfigurationValues.GOOGLE_COM_USERNAME);
        driverr.findElement(By.xpath("//input[@id='next']")).click();
        driverr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driverr.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(ConfigurationValues.GOOGLE_COM_PASSWORD);
        driverr.findElement(By.xpath("//input[@id='signIn']")).click();
        logger.info("Login in gmail");
        driverr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driverr.findElement(By.className("yW")).click();
        String incomeMessage = driverr.findElement(By.className("hP")).getText();
        logger.info("Message " + incomeMessage);
        Assert.assertEquals(incomeMessage, "Automation testing");
        driverr.quit();
    }
}
