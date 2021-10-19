package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.DressesPage;
import pages.LandingPage;


public class TestPlan {

    private final WebDriver driver = new ChromeDriver();
    LandingPage start = new LandingPage(driver);



    @BeforeTest
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);

    }

    @Test(testName = "Searching Product", priority = 1)
    public void firstTest(){

        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        start.searchProduct();

    }

    @Test(testName = "Placing Order", priority = 2)
    public void secondTest(){

        start.placeOrder();

    }

    @Test(testName = "First Order Checkout", priority = 3)
    public void thirdTest(){

        start.finalCheckout();

    }

    @Test(testName = "Order 'Evening Dresses'", priority = 4)
    public void fourthTest(){

        DressesPage dress = new DressesPage(driver);
        dress.selectDresses();


    }

    @Test(testName = "Second Order Checkout", priority = 5)
    public void fifthTest(){

        DressesPage dress = new DressesPage(driver);
        dress.orderCheckout();
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
