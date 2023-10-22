package objectselector;

import org.openqa.selenium.By;
public class addcartpage {
    By addcart = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]");
    By checkout = By.id("checkout");
    By continueshop = By.id("continue-shopping");
    By cartbadge = By.xpath("//span[@class='shopping_cart_badge']");
    By linkcart = By.xpath("//a[@class='shopping_cart_link']");

    public By getAddcart(){
        return addcart;
    }
    public By getCheckout(){
        return checkout;
    }
    public By getContinueshop(){
        return continueshop;
    }
    public By getCartbadge(){
        return cartbadge;
    }
    public By getLinkcart(){
        return linkcart;
    }
}
