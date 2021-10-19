package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DressesPage extends PageObject {


    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    private WebElement move_to_dresses;

    @FindBy(linkText = "Evening Dresses")
    private WebElement evening_dresses;

    public DressesPage(WebDriver driver) {
        super(driver);
    }

    public void selectDresses(){

        Actions new_action = new Actions(driver);
        new_action.moveToElement(move_to_dresses).click().build().perform();
        evening_dresses.click();


    }

    public void myWaitMethod(){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            //do nothing
        }
    }

}
