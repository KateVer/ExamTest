package com.bsu;

import com.bsu.steps.Steps;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWebDriverTest {
    private Steps steps;
    private final Logger logger = Logger.getLogger(SeleniumWebDriverTest.class);
    private final String USER_EMAIL = "testuser.te";
    private final String PASSWORD = "999RfnzZ";
    private final String USER_NAME = "testuser.te@yandex.ru";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to Yandex")
    public void oneCanLoginYandex(){
        logger.info("oneCanLoginYandex");
        steps.loginYandex(USER_EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USER_NAME));
    }
    @Test
    public void oneCanSearch(){
        logger.info("oneCanSearch");
        Assert.assertTrue(steps.searchPerformed("Сирия"));
    }

    @Test
    public void sendNoReciever(){
        logger.info("sendNoReciever");
        steps.loginYandex(USER_EMAIL, PASSWORD);
        Assert.assertFalse(steps.sendMessage("",""));
    }

    @Test
    public void sendReciever(){
        logger.info("sendNoReciever");
        steps.loginYandex(USER_EMAIL, PASSWORD);
        Assert.assertFalse(steps.sendMessage("ekaterinaverbitskaya94@gmail.com","Test"));
    }

//    @Test
//    public void receiveMess(){
//        steps.loginYandex(USER_EMAIL,PASSWORD);
//        int messNumber1 = steps.newMessNumber();
//        steps.sendMessage("testuser.te@yandex.by","Test");
//        int messNumber2 = steps.newMessNumber();
//        Assert.assertEquals(messNumber1+1,messNumber2);
//    }
//
//    @Test
//    public void oneCanCreatePinboard(){
//        logger.info("-----oneCanCreatePinboard");
//        steps.loginYandex(USER_EMAIL, PASSWORD);
//        String pinboardName = "testName" + Utils.getRandomString(5);
//        String pinboardDescription = "testDescription" + Utils.getRandomString(5);
//        steps.createNewPinboard(pinboardName, pinboardDescription);
//        Assert.assertEquals(pinboardName.toLowerCase(), steps.getPinboardName(pinboardName).toLowerCase());
//    }
//
//    @Test
//    public void oneCanDeletePinboard(){
//        logger.info("-----oneCanDeletePinboard");
//        String pinboardName = "testName" + Utils.getRandomString(5);
//        String pinboardDescription = "testDescription" + Utils.getRandomString(5);
//        steps.loginYandex(USER_EMAIL, PASSWORD);
//        steps.createNewPinboard(pinboardName, pinboardDescription);
//        steps.deletePinboard(pinboardName);
//        Assert.assertFalse(steps.pinboardFound(pinboardName));
//    }
//
//    @Test
//    public void oneCanFindPin(){
//        logger.info("-----oneCanFindPin");
//        steps.loginYandex(USER_EMAIL, PASSWORD);
//        Assert.assertTrue(steps.pinWithTextFound("swift"));
//    }
//
//    @Test
//    public void oneCanPin(){
//        logger.info("-----oneCanPin");
//        steps.loginYandex(USER_EMAIL,PASSWORD);
//
//        Assert.assertTrue(steps.addRandomPin());
//    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }

}
