package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {

    //*********Constructor*********
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By parentBy = By.id("products");
    private By childrenBy = By.id("product_name");

    public void firstProduct() {
        //*********Web Elements*********
        List<WebElement> childrenElements = findChildrenOfParent(parentBy, childrenBy);
        addFirstProductToCart(childrenElements);
        String toastMessage = "Product added to shopping cart!";
        checkToastMessage(toastMessage);
        driver.findElementByAccessibilityId(backButtonAccessibilityId).click();
    }
}