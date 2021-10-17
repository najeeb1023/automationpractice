package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageObject{

    private final String SEARCH = "T-Shirts";



    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/input[4]")
    private WebElement search_bar;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]")
    private WebElement first_item;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]")
    private WebElement add_quantity;





    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(){

        search_bar.isEnabled();
        search_bar.click();
        search_bar.sendKeys(SEARCH);
        search_bar.sendKeys(Keys.ENTER);
        Actions scroll = new Actions(driver);
        scroll.sendKeys(Keys.PAGE_DOWN).perform();
        myWaitMethod();
        first_item.click();
        myWaitMethod();
        add_quantity.click();
        scroll.sendKeys(Keys.ARROW_DOWN).perform();


    }

    public void myWaitMethod(){
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //do nothing
        }
    }


}
