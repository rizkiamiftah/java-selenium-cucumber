package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import objectselector.loginpage;
import java.util.concurrent.TimeUnit;
import static config.env.*;
public class login {
    loginpage elementLogin = new loginpage();
    @Given("User is on saucedemo login page")
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
    @When("User input valid email")
    public void input_valid_email(){
        driver.findElement(elementLogin.email()).sendKeys(getEmail); //using variable email
    }
    @And("User input valid password")
    public void input_valid_password(){
        driver.findElement(elementLogin.password()).sendKeys(getPassword);
    }
    @And("User click login button")
    public void click_login_button(){
        driver.findElement(elementLogin.login()).click(); //click the login button
    }
    @Then("User success directed to dashboard page")
    public void directed_dashboard_page(){
        String titleDashboard = driver.findElement(By.xpath("//div[@class='footer_copy']")).getText();
        Assert.assertEquals(titleDashboard, "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");

        //driver.findElement(By.xpath("(//div[@class='css-0'])[1]")).click();
    }
    @And("User input invalid password")
    public void input_invalid_password(){
        driver.findElement(elementLogin.password()).sendKeys(wrongPassword);
    }
    @Then("Display invalid credential alert")
    public void display_invalid_credential_alert(){
        String alertMessage = driver.findElement(elementLogin.alert()).getText();
        Assert.assertEquals(alertMessage,"Epic sadface: Username and password do not match any user in this service");
    }
    @And("User input invalid email")
    public void input_invalid_email(){
        driver.findElement(elementLogin.email()).sendKeys(invalidEmail);
    }
    @Then("Display invalid email alert")
    public void display_invalid_email_alert(){
        String alertMessage = driver.findElement(elementLogin.alert()).getText();
        Assert.assertEquals(alertMessage,"Epic sadface: Username and password do not match any user in this service");
    }
    @And("User input blank email")
    public void input_blank_email(){
        driver.findElement(elementLogin.email()).sendKeys("");
    }
    @Then("Display error blank email alert")
    public void display_error_blank_email_alert(){
        String alertMessage = driver.findElement(elementLogin.alert()).getText();
        Assert.assertEquals(alertMessage,"Epic sadface: Username is required");
    }
    @And("User input blank password")
    public void input_blank_password(){
        driver.findElement(elementLogin.password()).sendKeys("");
    }
    @Then("Display error blank password alert")
    public void display_error_blank_password_alert(){
        String alertMessage = driver.findElement(elementLogin.alert()).getText();
        Assert.assertEquals(alertMessage,"Epic sadface: Password is required");
    }
}
