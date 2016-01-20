package com.bsu.steps;

import com.bsu.pages.MailPage;
import com.bsu.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps {
    private final Logger logger = Logger.getLogger(Steps.class);
    private WebDriver driver;
    private int previousPinsNumber=0;
    private int currentPinsNumber=0;

    public void initBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver(){
        driver.quit();
        logger.info("Browser stoped");
    }

    public void loginYandex(String email, String password){
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.login(email,password);
        logger.info("Login yandex");
    }

    public boolean isLoggedIn(String username)
    {
        MainPage loginPage = new MainPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
    }

    public boolean searchPerformed(String message){
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.search(message);
        String text = "По вашему запросу ничего не нашлось";
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" +text +"')]"));
        return list.size() == 0;
    }

    public boolean sendMessage(String rec, String subj){
        MailPage mailPage = new MailPage(driver);
        mailPage.openPage();
        mailPage.sendMessage(rec,subj);
        return mailPage.messSent();
    }

    public int newMessNumber(){
        MailPage mailPage = new MailPage(driver);
        mailPage.openPage();
        return mailPage.newMessNumber();
    }

//    public boolean messageIsSent(String)

//    public boolean pinWithTextFound(String text){
//        MainPage mainPage = new MainPage(driver);
//        mainPage.searchText(text);
//        logger.info("Seacrh \" " + text + " \" was performed");
//        return mainPage.pinIsFound();
//    }


}
