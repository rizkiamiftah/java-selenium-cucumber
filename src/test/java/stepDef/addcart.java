package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectselector.addcartpage;
import objectselector.loginpage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static config.env.*;
import static config.env.driver;

public class addcart {
    addcartpage elementcart = new addcartpage();
    loginpage elementLogin = new loginpage();
    @Given("User on the login page")
    public void login_page() {
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
    @When("User input credential")
    public void input_credential(){
        driver.findElement(elementLogin.email()).sendKeys(getEmail); //using variable email
        driver.findElement(elementLogin.password()).sendKeys(getPassword);
    }
    @And("User click login")
    public void click_login(){
        driver.findElement(elementLogin.login()).click(); //click the login button
    }
    @Then("User successfully login")
    public void successfully_login(){
        String titleDashboard = driver.findElement(By.xpath("//div[@class='footer_copy']")).getText();
        Assert.assertEquals(titleDashboard, "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
    }
    @Given("User on dashboard")
    public void user_on_dashboard(){
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Products"); //assert the title header website
    }
    @When("User add cart button")
    public void add_cart_button(){
        driver.findElement(elementcart.getAddcart()).click();
    }
    @Then("Display count cart")
    public void display_count_cart(){
        boolean cartBadge = driver.findElement(elementcart.getCartbadge()).isDisplayed();
        Assert.assertTrue(cartBadge);
    }
    @When("User click icon cart")
    public void click_icon_cart(){
        driver.findElement(elementcart.getLinkcart()).click();
    }
    @Then("User directed to detail cart")
    public void directed_to_detail_cart(){
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
    }
    @Given("User on detail cart")
    public void detail_cart(){
        driver.findElement(elementcart.getLinkcart()).click();
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
    }
    @When("User click continue shopping")
    public void click_continue_shopping(){
        driver.findElement(elementcart.getLinkcart()).click();
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
        driver.findElement(elementcart.getContinueshop()).click();
    }
    @Then("User directed to dashboard")
    public void directed_to_dashboard(){
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Products"); //assert the title header website
    }
    @When("User click checkout")
    public void click_checkout(){
        driver.findElement(elementcart.getLinkcart()).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Your Cart"); //assert the title header website
        driver.findElement(elementcart.getCheckout()).click();
    }
    @Then("User directed to checkout page")
    public void directed_to_checkout_page(){
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Checkout: Your Information"); //assert the title header website
    }
}
