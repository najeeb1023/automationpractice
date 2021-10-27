package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {


    // protected means
    // public : can be accessed anywhere
    // private : can only be accessed in same class
    // protected : can only be accessed in same package
    protected WebDriver driver;

    public PageObject(WebDriver driver){


        this.driver = driver;
        PageFactory.initElements(driver, this);




    }

}
