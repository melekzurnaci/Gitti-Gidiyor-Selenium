import Pages.BasketPage;
import Pages.GittiGidiyorMainPage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestPage  {
    GittiGidiyorMainPage gittiGidiyorMainPage;
    LoginPage loginPage;
    BasketPage basketPage;


    public static WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver" ,"C:/Selenium/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver driver = webDriver();

    @Before
    public void setUp(){
        gittiGidiyorMainPage = new GittiGidiyorMainPage(driver);
        loginPage = new LoginPage(driver);
        basketPage = new BasketPage(driver);

    }
    @Test
    public void testPage() throws InterruptedException {
        loginPage.login("mlkzrnc@gmail.com","password1");
        gittiGidiyorMainPage.search("Bilgisayar");
        gittiGidiyorMainPage.goToSecondPage();
        basketPage.addToBasket();
        basketPage.priceControl();
        basketPage.deleteProduct();
        basketPage.basketControl();

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
