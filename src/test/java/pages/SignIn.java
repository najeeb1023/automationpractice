package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class SignIn extends PageObject{


        // dummy email, you can enter your desired email
        private final String EMAIL = "abc123Test@gmail.com";
    // dummy email, you can enter your desired email
        private final String REGISTERED_EMAIL = "abc123Test@gmail.com";
        private final String REGISTERED_EMAIL_MSG = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

        // dummy password, you can enter your own password;
        private final String PASSWORD = "dummypassword";


    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
    private WebElement sign_in_button;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input")
    private WebElement email;

    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    private WebElement scroll_to_text;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]/span[1]")
    private WebElement create_account;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement registered_user;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")
    private WebElement password;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
    private WebElement click_sign_in;

    public SignIn(WebDriver driver) {
        super(driver);
    }


    public void registerSignIn(){

        sign_in_button.click();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true)",scroll_to_text);
        myWaitMethod();
        email.click();
        email.sendKeys(EMAIL);
        create_account.click();
        myWaitMethod();
        String error_msg = driver.findElement(By.xpath("//li[contains(text(),'An account using this email address has already be')]")).getText();
        Assert.assertEquals(error_msg.contains("An account using this email address has already be"),"An account using this email address has already be");
        logIn();




    }

    public void logIn(){

        registered_user.click();
        registered_user.sendKeys(REGISTERED_EMAIL);
        password.click();
        password.sendKeys(PASSWORD);
        //If you want to login;
        // click_sign_in.click();



    }

    public void myWaitMethod(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
