package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectselector.addcartpage;
import objectselector.checkoutpage;
import objectselector.loginpage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static config.env.*;
import static config.env.driver;

public class checkout {
    checkoutpage elementcheckout = new checkoutpage();
    addcartpage elementcart = new addcartpage();
    loginpage elementLogin = new loginpage();

    @Given("User on the login state")
    public void login_state() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(BaseURL);
        String title = driver.findElement(By.xpath("//div[@class='login_logo']")).getText(); //get element title header
        Assert.assertEquals(title, "Swag Labs"); //assert the title header website
        //driver.close();
    }
    @When("User input username password")
    public void input_username_password(){
        driver.findElement(elementLogin.email()).sendKeys(getEmail); //using variable email
        driver.findElement(elementLogin.password()).sendKeys(getPassword);
    }
    @And("User tap login")
    public void tap_login(){
        driver.findElement(elementLogin.login()).click(); //click the login button
    }
    @Then("User success login")
    public void success_login(){
        String titleDashboard = driver.findElement(By.xpath("//div[@class='footer_copy']")).getText();
        Assert.assertEquals(titleDashboard, "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
    }
    @Given("User is on dashboard")
    public void user_is_on_dashboard(){
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Products"); //assert the title header website
    }
    @When("User tap cart button")
    public void tap_cart_button(){
        driver.findElement(elementcart.getAddcart()).click();
    }
    @Then("Display count order")
    public void display_count_order(){
        boolean cartBadge = driver.findElement(elementcart.getCartbadge()).isDisplayed();
        Assert.assertTrue(cartBadge);
    }
    @When("User tap icon cart")
    public void tap_icon_cart(){
        driver.findElement(elementcart.getLinkcart()).click();
    }
    @Then("User direct to detail cart")
    public void direc_to_detail_cart(){
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
    }
    @Given("User on detailed cart")
    public void detailed_cart(){
        driver.findElement(elementcart.getLinkcart()).click();
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
    }
    @When("User tap checkout")
    public void tap_checkout(){
        driver.findElement(elementcart.getLinkcart()).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
        driver.findElement(elementcart.getCheckout()).click();
    }
    @Then("User direct to checkout page")
    public void direct_to_checkout_page(){
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Checkout: Your Information"); //assert the title header website
    }
    @Given("User on checkout page")
    public void checkout_page(){
        driver.findElement(elementcart.getLinkcart()).click();
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
        driver.findElement(elementcart.getCheckout()).click();
        String titlepage = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(titlepage, "Checkout: Your Information"); //assert the title header website
    }
    @When("User click cancel")
    public void click_cancel(){
        driver.findElement(elementcheckout.getCancel()).click();
    }
    @Then("User directed back to detail cart")
    public void back_detail_cart(){
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
    }
    @When("User input the form")
    public void input_form(){
        driver.findElement(elementcheckout.getFirstname()).sendKeys(firstName);
        driver.findElement(elementcheckout.getLastname()).sendKeys(lastName);
        driver.findElement(elementcheckout.getPoscode()).sendKeys(postCode);
    }
    @And("User click continue")
    public void click_continue(){
        driver.findElement(elementcheckout.getLanjut()).click();
    }
    @Then("User directed to overview page")
    public void directed_overview_page(){
        String title = driver.findElement(elementcheckout.getTitle()).getText(); //get element title header
        Assert.assertEquals(title, "Checkout: Overview"); //assert the title header website
    }
}
