package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class DmsPage extends BasePage {
    //кнопка "Отправить заявку"
    private static final String DMS_LOC = "//*[@class='btn btn-default text-uppercase hidden-xs adv-analytics-navigation-desktop-floating-menu-button']";
    //заголовок "Добровольное медицинское страхование"
    private static final String DMS_HEADER_LOC = "//*[contains(text(), 'Добровольное медицинское страхование')][@class='content-document-header']";
    //окошко с данными
    private static final String WINDOW_DMS_LOC = "//*[@class='modal-content']";
    //заголовок "Заявка на добровольное медицинское страхование"
    private static final String APPLICATION_DMS_HEADER_LOC = "//*[@data-bind='text: options.title']";

    public DmsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void containsDms() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement actualPageHeader = driver.findElement(By.xpath(DMS_HEADER_LOC));
        wait.until(ExpectedConditions.visibilityOf(actualPageHeader));
        String actualPageHeaderText = actualPageHeader.getText();
        Assertions.assertEquals("Добровольное медицинское страхование", actualPageHeaderText.trim(), "Не совпадает название раздела с заголовком!");
    }

    public void clickHealthButton() {
        WebElement healtButton = driver.findElement(By.xpath(DMS_LOC));
        wait.until(ExpectedConditions.visibilityOf(healtButton));
        healtButton.click();
    }

    public void clickWindowDms() {
        WebElement windowDmsClick = driver.findElement(By.xpath(WINDOW_DMS_LOC));
        wait.until(ExpectedConditions.visibilityOf(windowDmsClick));
        windowDmsClick.click();
    }

    public void containsApplicationDms() {
        WebElement actualPageHeader = driver.findElement(By.xpath(APPLICATION_DMS_HEADER_LOC));
        wait.until(ExpectedConditions.visibilityOf(actualPageHeader));
        String actualPageHeaderText = actualPageHeader.getText();
        Assertions.assertEquals("Заявка на добровольное медицинское страхование", actualPageHeaderText.trim(), "Не совпадает название раздела с заголовком!");
    }
}