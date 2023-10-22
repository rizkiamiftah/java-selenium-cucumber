package objectselector;

import org.openqa.selenium.By;
public class loginpage {
    By fieldEmail = By.id("user-name");
    By fieldPassword = By.id("password");
    By buttonLogin = By.id("login-button");
    By alertMessage = By.xpath("//div[@class='error-message-container error']");

    public By email() {
        return fieldEmail;
    }
    public By password(){
        return fieldPassword;
    }
    public By login(){
        return buttonLogin;
    }
    public By alert(){
        return alertMessage;
    }
}
