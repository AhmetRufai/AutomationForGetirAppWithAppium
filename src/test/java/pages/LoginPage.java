package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    private By userNameBy = By.id("email");
    private By passwordBy = By.id("password");
    private By loginButtonBy = By.id("email_sign_in_button");

    public void login(String userName, String password) {
        writeText(userNameBy, userName);
        writeText(passwordBy, password);
        clickWithFindElement(loginButtonBy);
    }
}