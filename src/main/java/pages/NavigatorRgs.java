package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigatorRgs extends BasePage {
    private static final String PAGE_MENU_LOC = "//*[@class ='hidden-xs'][@data-toggle]";
    private static final String COOKIES_LOC = "//*[@class='btn btn-default text-uppercase']";

    public NavigatorRgs(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickMenuButton() {
        WebElement categoriesElement = driver.findElement(By.xpath(PAGE_MENU_LOC));
        wait.until(ExpectedConditions.visibilityOf(categoriesElement));
        categoriesElement.click();
    }
    public void clickCookiesButton() {
        WebElement cookiesElement = driver.findElement(By.xpath(COOKIES_LOC));
        wait.until(ExpectedConditions.visibilityOf(cookiesElement));
        cookiesElement.click();
    }
}
