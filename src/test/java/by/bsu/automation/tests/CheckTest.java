package by.bsu.automation.tests;

import by.bsu.automation.SignPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
/**
 * Created by kateverbitskaya on 20.12.2015.
 */
public class CheckTest {

    private static Logger logger = Logger.getLogger(CheckTest.class);

    SignPage signPage = new SignPage();

    @Test
    public void testOneCanLogin() {
        WebDriver driver = signPage.signIn();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        logger.info("Login in system");

        driver.quit();
    }
}
