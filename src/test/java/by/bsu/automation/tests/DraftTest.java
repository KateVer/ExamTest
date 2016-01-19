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


/**
 * Created by kateverbitskaya on 19.01.16.
 */
public class DraftTest {
    private static Logger logger = Logger.getLogger(DraftTest.class);
    private final By madeDraft = By.xpath("//span[@class='header-user-name js-header-user-name']");


    SignPage signPage = new SignPage();

    @Test
    public void testOneCanMakeDraft() {
        WebDriver driver = signPage.signIn();
        logger.info("Login in system");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[@class='b-ico b-ico_compose']")).click();
        driver.findElement(By.xpath("//input[@name='subj']")).sendKeys("Draft");
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//a[text()='Черновики'")).click();
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        String madeNewDraft = driver.findElement(madeDraft).getText();
//        logger.info("Username in system" + madeNewDraft);
//        Assert.assertEquals(madeNewDraft, "Draft");

        driver.quit();
    }
}