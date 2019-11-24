package tests;

import org.testng.annotations.Test;
import pages.CardPage;
import pages.CategoryPage;
import pages.LoginPage;
import pages.ProductPage;

public class TestCases extends BaseTest {
    @Test()
    public void testCase1() {
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CardPage cardPage = new CardPage(driver);

        loginPage.login("hello@getir.com", "hello");
        categoryPage.category("Kişisel Bakım");
        productPage.firstProduct();
        categoryPage.category("Ev Bakımı");
        productPage.firstProduct();
        cardPage.clearCard();
    }
}