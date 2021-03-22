package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BasePage {

    WebDriverWait wait ;

    public static WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver" ,"C:/Selenium/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver driver = webDriver();

    //Constructor
    public BasePage (WebDriver driver ){
            this.driver = driver;
            this.wait = new WebDriverWait(driver,10,1000);
    }

    // Click method
    public void  onClick(By elementLocation) {
        findElement(elementLocation).click();
    }
    // Write text
    public  void writeKey(By elementLocation , String key ) {
        findElement(elementLocation).sendKeys(key);
    }

    // find element
    public WebElement findElement(By by){

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public int randomProduct (){
        Random random = new Random();
        int rand = random.nextInt(49) + 1;
        return rand;
    }

    //    // Read Text
//    public String getString(By elementLocation){
//        return driver.findElement(elementLocation).getText();
//    }
//
//    // Get element
//    public WebElement getElement(By elementLocation){
//        return driver.findElement(elementLocation);
//    }


}
