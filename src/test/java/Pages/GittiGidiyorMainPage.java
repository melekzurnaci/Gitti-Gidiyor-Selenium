package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GittiGidiyorMainPage extends  BasePage{


    public GittiGidiyorMainPage(WebDriver driver) {
        super(driver);

    }
    JavascriptExecutor js = (JavascriptExecutor)driver;
    // WebElements
    public static final By SEARCH_TEXT=By.name("k");
    public static final By Search_Button = By.cssSelector(".qjixn8-0.sc-1bydi5r-0.hKfdXF");
    public static By secondPageButton = By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]");


    public void search(String key){
        writeKey(SEARCH_TEXT,key);
        onClick(Search_Button);
        System.out.println("Bilgisayar kelimesi aratıldı..");
    }

    public  void goToSecondPage(){
      //  js.executeScript("window.scrollBy(0,2000)");
        js. executeScript("arguments[0].scrollIntoView(true);",findElementM(secondPageButton));
        onClick(secondPageButton);
        System.out.println("2. sayfaya gidildi..");
    }



}
