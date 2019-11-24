package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

class BasePage {
    AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    String backButtonAccessibilityId;
    String cardButtonId;

    //Constructor
    BasePage(WebDriver driver) {
        this.driver = (AppiumDriver<MobileElement>) driver;
        wait = new WebDriverWait(driver, 10);
        // Add to Cart and Back buttons are on each page, so their IDs were created here
        backButtonAccessibilityId = "Navigate up";
        cardButtonId = "basket";
    }

    //Wait Visibility of Element
    private void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //Wait Presence of Element
    private void waitPresence(By elementBy) {
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    //Wait Invisibility of Element with Text
    private void waitInvisibility(By elementBy, String text) {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(elementBy, text));
    }

    //Click Method with findElement
    void clickWithFindElement(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    private String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    // Check Toast Message
    void checkToastMessage(String toastMessage) {
        waitPresence(By.xpath(".//*[contains(@text,'" + toastMessage + "')]"));
        waitInvisibility(By.xpath(".//*[contains(@text,'" + toastMessage + "')]"), toastMessage);
    }

    // Find Children of a Parent Element
    List<WebElement> findChildrenOfParent(By parentBy, By childrenBy) {
        waitVisibility(parentBy);
        WebElement parentElement = driver.findElement(parentBy);
        return parentElement.findElements(childrenBy);
    }

    // Add The First Product in a Category Group to The Cart
    void addFirstProductToCart(List<WebElement> elementList) {
        if (elementList.size() > 0) {
            elementList.get(0).click();
        } else {
            System.out.println("Bu kategori altında ürün yok");
        }
    }

    // Remove All Products From The Cart
    void removeAllProductsFromCart(List<WebElement> elementList, By productNameByForToastMessage, String secondPartOfToastMessage) {
        String mProductName;
        String mToastText;
        for (int i = 0; i < elementList.size(); i++) {
            mProductName = readText(productNameByForToastMessage);
            mToastText = mProductName + " " + secondPartOfToastMessage;
            elementList.get(0).click();
            checkToastMessage(mToastText);
        }
    }
}