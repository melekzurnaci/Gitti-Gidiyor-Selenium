package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public static By secondPageButton = By.cssSelector("a[href='/arama/?k=Bilgisayar&sf=2']");
    public static By productPrice1= By.cssSelector("p[class='fiyat price-txt robotobold price']");
    public static By productDetailButton = By.cssSelector("[class='catalog-view clearfix products-container']>:nth-child(1)");
    public static By addToBasketButton =By.xpath("//*[@id='add-to-basket']");
    public static By price2 = By.cssSelector("div[class='total-price']");
    public static By addButton = By.cssSelector("option[value='2']");
    public static By totalAmount = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-child(1)");
    public static By deleteButton = By.cssSelector("a[title='Sil']");
    public static By basketControl = By.cssSelector("div[class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']>:nth-child(1)");
    public static  By firstPrice = By.cssSelector("#best-match-right > div.blueWrapper.clearfix > div.clearfix > ul > li");

    JavascriptExecutor js = (JavascriptExecutor)driver;

    public void selectProduct(){
       int  rand = randomProduct();
       By PRODUCT = By.xpath("//div[@class='clearfix']/ul[@class='catalog-view clearfix products-container']/li["+rand+"]/a[@class='product-link']");
       onClick(PRODUCT);
       System.out.println("Rastgele ürün seçildi");
      // return   PRODUCT;
    }

    public void addToBasket() throws InterruptedException {
        selectProduct();
        js.executeScript("arguments[0].scrollIntoView(true);",findElement(addToBasketButton));
        Thread.sleep(2000);
        onClick(addToBasketButton);
        System.out.println("Sepete eklendi.");
    }

}
