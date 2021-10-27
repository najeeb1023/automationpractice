package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DressesPage extends PageObject {


    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    private WebElement move_to_dresses;

    @FindBy(linkText = "Evening Dresses")
    private WebElement evening_dresses;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement evening_dress_select;

    @FindBy(xpath = "//body/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]/i[1]")
    private WebElement add_quantity;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement select_dropdown;

    @FindBy(xpath = "//option[contains(text(),'M')]")
    private WebElement select_size;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement add_to_cart;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
    private WebElement proceed_to_checkout;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")
    private WebElement final_checkout;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[1]/a[1]")
    private WebElement home_button;

    public DressesPage(WebDriver driver){
        super(driver);
}



    public void selectDresses(){

        Actions new_action = new Actions(driver);
        new_action.clickAndHold(move_to_dresses).click().build().perform();
        evening_dresses.click();
        myWaitMethod();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",evening_dress_select);
        evening_dress_select.click();
        myWaitMethod();
        driver.switchTo().frame(0);
        add_quantity.click();
        select_dropdown.click();
        myWaitMethod();
        select_size.click();
        new_action.sendKeys(Keys.ESCAPE).perform();

    }

    public void orderCheckout(){

        add_to_cart.click();
        myWaitMethod();
        driver.switchTo().defaultContent();
        proceed_to_checkout.click();
        //driver.switchTo().defaultContent();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",final_checkout);
        final_checkout.click();
        home_button.click();

    }

    public void myWaitMethod(){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            //do nothing
        }
    }

}
