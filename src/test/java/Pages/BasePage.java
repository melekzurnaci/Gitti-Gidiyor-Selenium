package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BasePage {

    WebDriverWait wait ;
    public static WebDriver driver;

    //Constructor
    public BasePage (WebDriver driver ){
            this.driver = driver;
            this.wait = new WebDriverWait(driver,12,1000);
    }

    // Click method
    public void  onClick(By elementLocation) {
        findElementM(elementLocation).click();
    }
    // Write text
    public  void writeKey(By elementLocation , String key ) {
        findElementM(elementLocation).sendKeys(key);
    }

    // find element
    public WebElement findElementM(By by){

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }



    public int randomProduct (){
        Random random = new Random();
        int rand = random.nextInt(49) + 1;
        return rand;
    }


    public String getString(By elementLocation){
        return driver.findElement(elementLocation).getText();
    }



}
