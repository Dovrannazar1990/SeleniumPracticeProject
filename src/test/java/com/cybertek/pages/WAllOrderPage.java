package com.cybertek.pages;

import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WAllOrderPage {

    @FindBy(xpath = "//h2[normalize-space(.)='List of All Orders']")
    public WebElement header;

    @FindBy(xpath = "//p/a[.='Check All']")
    public WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement unCheckAllButton;

    public WAllOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}