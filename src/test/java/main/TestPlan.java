package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.DressesPage;
import pages.LandingPage;
import pages.SignIn;


public class TestPlan{

    private final WebDriver driver = new ChromeDriver();
    LandingPage start = new LandingPage(driver);




    @BeforeTest
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);

    }

    @Test(testName = "Searching Product", priority = 1)
    public void didSearchProduct(){

        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        start.searchProduct();


    }

    @Test(testName = "Placing Order", priority = 2)
    public void wasOrderPlaced(){

        start.placeOrder();

    }

    @Test(testName = "First Order Checkout", priority = 3)
    public void didCheckoutFirstOrder(){

        start.finalCheckout();

    }

    @Test(testName = "Order 'Evening Dresses'", priority = 4)
    public void didOrderEveningDresses(){

        DressesPage dress = new DressesPage(driver);
        dress.selectDresses();


    }

    @Test(testName = "Second Order Checkout", priority = 5)
    public void didCheckoutSecondOrder(){

        DressesPage dress = new DressesPage(driver);
        dress.orderCheckout();
    }

    @Test(testName = "Sign In", priority = 6)
    public void didSignIn(){

        driver.get("http://automationpractice.com/index.php");
        SignIn sign = new SignIn(driver);
        sign.registerSignIn();
    }



    @AfterTest
    public void endTest(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();




    }

}
