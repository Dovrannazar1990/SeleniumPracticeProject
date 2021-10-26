package com.cybertek.pages;

import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage {

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userNameField;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordField;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton;

    // Now we need to instruct selenium to start looking for element
    // when this constructor is called
    // This is no arg constructor of this class
    public WLoginPage() {
        // PageFactory is a selenium class that supports Page Object Model
        // And it has method called initElements
        // Once it's called, it will locate all the element
        // Specified using @FindBy annotation with locator
        // InitElements accept 2 arguments,
        // WebDriver instance and Page class instance (this) means current instance of this class.

        PageFactory.initElements(Driver.getDriver(), this);


    }

}