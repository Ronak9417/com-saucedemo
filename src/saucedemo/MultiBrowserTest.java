package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "Chrome";

    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        // Open the URL into Browser
        driver.get(baseUrl);
        //maximise the Browser
        driver.manage().window().maximize();
        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get the current URL
        System.out.println("Current URL : " + driver.getCurrentUrl());

        //Get page source
        System.out.println("Page source : " + driver.getPageSource());

        // Find the Username field element
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("Ronak Patel");

        // Find the password field element and type the password
        driver.findElement(By.name("password")).sendKeys("prime123");

    }

}
