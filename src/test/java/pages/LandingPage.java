package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends PageObject{

    private final String SEARCH = "T-Shirts";



    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement search_bar;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement img_click;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/form[1]")
    private WebElement compare_icon;

    @FindBy(xpath = "//body/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]/i[1]")
    private WebElement add_quantity;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement size_dropdown;

    @FindBy(xpath = "//option[contains(text(),'L')]")
    private WebElement select_size;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement add_to_cart;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
    public WebElement checkout;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")
    public WebElement final_checkout;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[1]/a[1]")
    private WebElement home_button;








    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(){

        search_bar.isEnabled();
        search_bar.click();
        search_bar.sendKeys(SEARCH);
        search_bar.sendKeys(Keys.ENTER);
        myWaitMethod();

    }

    public void placeOrder(){
        Actions new_action = new Actions(driver);


        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",img_click);
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(img_click));
        new_action.moveToElement(img_click).perform();
        myWaitMethod();
        new_action.click(img_click).perform();
        myWaitMethod();
        driver.switchTo().frame(0);
        myWaitMethod();
        add_quantity.click();
        size_dropdown.click();
        select_size.click();
        new_action.sendKeys(Keys.ENTER);



    }

    public void finalCheckout(){

        add_to_cart.click();
        myWaitMethod();
        driver.switchTo().defaultContent();
        checkout.click();
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
