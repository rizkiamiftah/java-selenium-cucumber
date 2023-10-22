package config;

import org.openqa.selenium.WebDriver;

public class env {
    public static WebDriver driver; //init webdriver
    public static String BaseURL = "https://www.saucedemo.com/"; //init base url
    public static String getEmail = "standard_user";
    public static String getPassword = "secret_sauce";
    public static String wrongPassword = "lupa";
    public static String invalidEmail = "sel-123.com";
    public static String firstName = "test";
    public static String lastName = "coba";
    public static String postCode = "43434";
}
