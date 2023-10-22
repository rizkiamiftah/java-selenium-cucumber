package objectselector;

import org.openqa.selenium.By;

public class dashboardpage {

    By sidebar = By.id("react-burger-menu-btn");
    By logout = By.xpath("//a[@id='logout_sidebar_link']");
    By cart = By.xpath("//a[@class='shopping_cart_link']");
    By sort = By.xpath("//select[@class='product_sort_container']");
    By imageproduct = By.xpath("//img[@alt='Sauce Labs Backpack']");
    By titleproduct = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");

    public By getSidebar(){
        return sidebar;
    }
    public By getLogout(){
        return logout;
    }
    public By getCart(){
        return cart;
    }

    public By getSort(){
        return sort;
    }
    public By getImageproduct(){
        return imageproduct;
    }
    public By getTitleproduct(){
        return titleproduct;
    }

}
