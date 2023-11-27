package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValidCredentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * <p>
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * <p>
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 */
public class LogIn extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginWithValidCredentials() throws InterruptedException {

        //Enter username in username field
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter password
        sendTextToElement(By.id("password"), "secret_sauce");

        //Click on 'Login' button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        Thread.sleep(3000);

        //verify the text 'Products'
        String expectedMessage = "Products";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='header_secondary_container']"));
        Thread.sleep(4000);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {

        //Enter username in username field
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter password
        sendTextToElement(By.id("password"), "secret_sauce");

        //Click on 'Login' button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //Verify that six products are displayed on page

        List<WebElement> count = driver.findElements
                (By.xpath("//div[@class='inventory_item']"));
        int totalcount = count.size();
        System.out.println("Total Products are : " + totalcount);
        Thread.sleep(4000);
    }

    @After
    public void TearDown() {
        closeBrowser();
    }
}
