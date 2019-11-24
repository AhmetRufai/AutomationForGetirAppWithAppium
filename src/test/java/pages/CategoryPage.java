package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage {

    //*********Constructor*********
    public CategoryPage(WebDriver driver) {
        super(driver);
    }


    public void category(String categoryName) {
        By categoryNameBy = By.xpath("//*[@text=\"" + categoryName + "\"]");
        clickWithFindElement(categoryNameBy);
    }
}