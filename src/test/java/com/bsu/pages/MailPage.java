package com.bsu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by kateverbitskaya on 20.01.16.
 */
public class MailPage extends Page {

    private final String BASE_URL = "https://mail.yandex.by/";

    @FindBy(xpath = "//img[@class='b-ico b-ico_compose']")
    private WebElement writeMessage;

    @FindBy(xpath = "//div[contains(@class, 'js-compose-mail-input_to')]//input[1]")
    private WebElement address;

    @FindBy(xpath = "//input[@name='subj']")
    private WebElement messageText;

    @FindBy(xpath = "//button[@id='nb-18']")
    private WebElement buttonSend;

    @FindBy(xpath = "//a[@class='b-folders__folder__link']")
    private WebElement newMessages;


    public void sendMessage(String reciever, String subject){
        writeMessage.click();
        address.sendKeys(reciever);
        messageText.sendKeys(subject);
        buttonSend.click();
    }



    public MailPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean messSent(){
        String text = "Поле не заполнено. Необходимо ввести адрес.";
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" +text +"')]"));
        if (list.size() == 0)
            return true;
        else
            return false;
    }

    public int newMessNumber(){
        return Integer.parseInt(newMessages.getText());
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }
}
