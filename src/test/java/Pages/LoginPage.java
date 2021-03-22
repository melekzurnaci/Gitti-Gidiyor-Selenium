package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
    }

    public static By loginButton = By.xpath("//div[@class='gekhq4-4 hwMdSM']");
    public static By loginB = By.cssSelector("[data-cy='header-login-button']");
    public static By User_Name = By.id("L-UserNameField");
    public static By Password = By.id("L-PasswordField");
    public static By login_Enter = By.id("gg-login-enter");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) throws InterruptedException {
        //go to loginpage
        onClick(loginButton);
        Thread.sleep(1000);
        onClick(loginB);
        Thread.sleep(1000);

        // Write Email to textbox
        writeKey(User_Name,username);

        writeKey(Password,password);

        // Sleep a little bit for page load
        Thread.sleep(2000);

        // Click Next
        onClick(login_Enter);

        System.out.println("Login yapıldı..");
    }

}
