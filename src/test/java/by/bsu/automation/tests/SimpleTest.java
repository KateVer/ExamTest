package by.bsu.automation.tests;

import by.bsu.automation.SignPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by kateverbitskaya on 20.12.2015.
 */
public class SimpleTest {

    private static Logger logger = Logger.getLogger(SimpleTest.class);

    private final By userNameInSystem = By.xpath("//span[@class='header-user-name js-header-user-name']");
    SignPage signPage = new SignPage();

    @Test
    public void testOneCanLogin() {
        WebDriver driver = signPage.signIn();
        logger.info("Login in system");

        String userName = driver.findElement(userNameInSystem).getText();
        logger.info("Username in system" + userName);
        Assert.assertEquals(userName, "testuser.te@yandex.ru");
        driver.quit();
    }
}
