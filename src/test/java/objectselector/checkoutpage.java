package objectselector;

import org.openqa.selenium.By;

public class checkoutpage {
    By cancel = By.id("cancel");
    By lanjut = By.id("continue");
    By firstname = By.id("first-name");
    By lastname = By.id("last-name");
    By poscode = By.id("postal-code");
    By title = By.xpath("//span[@class='title']");

    public By getCancel(){
        return cancel;
    }
    public By getLanjut(){
        return lanjut;
    }
    public By getFirstname(){ return firstname;}
    public By getLastname(){ return lastname;}
    public By getPoscode(){return poscode;}
    public By getTitle(){return title;}
}
