package com.bsu.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page{
    private final Logger logger = Logger.getLogger(MainPage.class);
    private final String BASE_URL = "https://www.yandex.by";

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputEmail;


    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//span[@class='header-user-name js-header-user-name']")
    private WebElement linkLoggedInUser;

    @FindBy(xpath = "//input[@id='text']")
    private WebElement searchLine;

    @FindBy(xpath = "//button[@class='button suggest2-form__button button_theme_websearch button_size_m i-bem button_js_inited']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()=' — Википедия']")
    private WebElement foundElement;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public void login(String userEmail, String password)
    {
        inputEmail.sendKeys(userEmail);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
    }

    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }

    public void search(String text){
        searchLine.sendKeys(text);
        searchButton.click();
    }

}
