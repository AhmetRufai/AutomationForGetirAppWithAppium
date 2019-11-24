package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CardPage extends BasePage {

    //*********Constructor*********
    public CardPage(WebDriver driver) {
        super(driver);
    }

    private By cardButtonIdBy = By.id(cardButtonId);
    private By parentBy = By.id("basket_products");
    private By childrenBy = By.id("imageview_remove");
    private By productNameBy = By.id("product_name");
    private By emptyPageIdInCardBy = By.id("empty_textview");

    public void clearCard() {
        clickWithFindElement(cardButtonIdBy);
        //*********Web Elements*********
        List<WebElement> childrenElements = findChildrenOfParent(parentBy, childrenBy);
        String secondPartOfToastMessage = "removed from your shopping cart!";
        removeAllProductsFromCart(childrenElements, productNameBy, secondPartOfToastMessage);
        try {
            String emptyPageTextInCard = "Your card is empty!";
            assertEquals(emptyPageIdInCardBy, emptyPageTextInCard);
        } catch (AssertionError ae) {
            Assert.fail("\n" + "Sepet boş olmasına rağmen sepet boş yazısı görünür olmadı veya beklenen metin görüntülenmedi" + "\n" + ae);
        }
    }
}