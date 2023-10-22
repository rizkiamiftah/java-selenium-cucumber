package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectselector.dashboardpage;
import objectselector.loginpage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static config.env.*;
import static config.env.getPassword;

public class dashboard {
    dashboardpage elementdashboard = new dashboardpage();
    loginpage elementLogin = new loginpage();

    @Given("User on the saucedemo login page")
    public void saucedemo_login_page() {
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
    @When("User input valid credentials")
    public void input_valid_email(){
        driver.findElement(elementLogin.email()).sendKeys(getEmail); //using variable email
        driver.findElement(elementLogin.password()).sendKeys(getPassword);
    }
    @And("User click the login")
    public void click_login(){
        driver.findElement(elementLogin.login()).click(); //click the login button
    }
    @Then("User should be logged in successfully")
    public void logged_in_successfully(){
        String titleDashboard = driver.findElement(By.xpath("//div[@class='footer_copy']")).getText();
        Assert.assertEquals(titleDashboard, "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
    }
    @Given("User on dashboard page")
    public void user_on_dashboard(){
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText(); //get element title header
        Assert.assertEquals(title, "Products"); //assert the title header website
    }
    @When("User click cart")
    public void click_cart(){
        driver.findElement(elementdashboard.getCart()).click();
    }
    @Then("User should be directed to cart page")
    public void directed_cart_page(){
        String cartTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(cartTitle, "Your Cart");
    }
    @When("User sort name product z to a")
    public void click_sort_name_product_z_to_a(){
        WebElement dropdownElement = driver.findElement(elementdashboard.getSort());
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Name (Z to A)");
    }
    @Then("Display the list of product")
    public void display_list_of_product(){
        String productTitle = driver.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText();
        Assert.assertEquals(productTitle, "Test.allTheThings() T-Shirt (Red)");
    }
    @When("User click title product")
    public void click_title_product(){
        driver.findElement(elementdashboard.getTitleproduct()).click();
    }
    @Then("User should be directed to detail product")
    public void directed_to_detail_product(){
        String productTitle = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(productTitle, "Sauce Labs Backpack");
    }
    @When("User click image product")
    public void click_image_product(){
        driver.findElement(elementdashboard.getImageproduct()).click();
    }
    @Then("User should to detail product")
    public void to_detail_product(){
        String productTitle = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(productTitle, "Sauce Labs Backpack");
    }
    @When("User click sidebar menu")
    public void click_sidebar_menu(){
        driver.findElement(elementdashboard.getSidebar()).click();
    }
    @And("User click logout")
    public void click_logout(){
        driver.findElement(elementdashboard.getLogout()).click();
    }
    @Then("User success logout")
    public void success_logout(){
        String title = driver.findElement(By.xpath("//div[@class='login_logo']")).getText(); //get element title header
        Assert.assertEquals(title, "Swag Labs"); //assert the title header website
    }
}
