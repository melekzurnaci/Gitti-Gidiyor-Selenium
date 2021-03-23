package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public static By firstPrice = By.id("sp-price-lowPrice");
    public static By addToBasketButton =By.xpath("//*[@id='add-to-basket']");
    public static By secondPrice = By.cssSelector("p[class='new-price']");
    public static By deleteButton = By.xpath("//*[@class='btn-delete btn-update-item hidden-m']");
    public static By basketControl    = By.xpath("//*[@class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']/h2");
    //*[@id="empty-cart-container"]/div[1]/div[1]/div/div[2]/h2
    public static By myBasket = By.xpath("//*[@id='header_wrapper']/div[4]/div[3]");
    JavascriptExecutor js = (JavascriptExecutor)driver;

    public void selectProduct(){
       int  rand = randomProduct();
       By PRODUCT = By.xpath("//div[@class='clearfix']/ul[@class='catalog-view clearfix products-container']/li["+rand+"]/a[@class='product-link']");
       onClick(PRODUCT);
       System.out.println("Rastgele ürün seçildi");
    }

    public void addToBasket() throws InterruptedException {
        selectProduct();
        js.executeScript("arguments[0].scrollIntoView(true);",findElementM(addToBasketButton));
        Thread.sleep(2000);
        onClick(addToBasketButton);
        System.out.println("Sepete eklendi.");
    }
    public void goToBasket(){
        onClick(myBasket);
    }
    public void priceControl() throws InterruptedException {
       String price = getString(firstPrice);
       Thread.sleep(1000);
       goToBasket();
       String price2 = getString(secondPrice);
       System.out.println(price +" - "+ price2);
       Assert.assertEquals("Fiyatlar eşit değildir." , price,price2);

    }
    public void deleteProduct(){
        onClick(deleteButton);
        System.out.println("ürün silindi.");
    }

    public void basketControl() throws InterruptedException {
        Thread.sleep(1000);
        String bildirim = getString(basketControl);

        Assert.assertEquals("Sepetiniz boş değil.",bildirim,"Sepetinizde ürün bulunmamaktadır.");

//        System.out.println(bildirim);
//        if (bildirim.equals("Sepetinizde ürün bulunmamaktadır.")){
//            System.out.println("Sepetinizde ürün bulunmamaktadır.");
//        }else{
//            System.out.println("Sepetinizde ürün bulunuyor.");
//        }
    }

}
