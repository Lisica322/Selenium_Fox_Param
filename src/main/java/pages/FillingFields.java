package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FillingFields extends BasePage {

    public FillingFields(WebDriver webDriver) {
        super(webDriver);
    }

    public final static String LAST_NAME_LOC = "//*[@name='LastName']";
    public final static String FIRST_NAME_LOC = "//*[@name='FirstName']";
    public final static String MIDDLE_NAME_LOC = "//*[@name='MiddleName']";
    public final static String PHONE_NUMBER_LOC = "//*[starts-with(@data-bind, 'value: Phone')]";
    public final static String DATE_CONNECTION_LOC = "//*[@name='ContactDate']";
    public final static String COMMENT_LOC = "//*[@name='Comment']";
    public final static String CHECKBOX_LOC = "//*[@class='checkbox']";
    public final static String MAIL_LOC = "//*[@name='Email']";
    public final static String OK_LOC = "//*[@class='btn btn-primary btn-sm text-uppercase text-semibold']";
    public final static String OK_MESSAGE_LOC = "//*[@class='validation-error-text']";
    public final static String CLICK_REGION_LOC = "//*[@name='Region']";
    public final static String CLICK_SPACE_LOC = "//*[@class ='checkbox checkbox-attention margin-bottom-ms--2 margin-top-ms--2']";
    public final static String OK_SPACE_LOC = "//*[@class ='col-md-12 col-xs-12']";


    public void onlyClickField(String namePath) {
        WebElement spaceField = driver.findElement(By.xpath(namePath));
        wait.until(ExpectedConditions.visibilityOf(spaceField));
        spaceField.click();
    }


    public void clickCheckboxField() {

        WebElement checkboxBtn = driver.findElement(By.xpath(CHECKBOX_LOC));
        checkboxBtn.click();
    }

    public void checkOkField() {
        WebElement actualPageHeader = driver.findElement(By.xpath(OK_MESSAGE_LOC));
        wait.until(ExpectedConditions.visibilityOf(actualPageHeader));
        String actualPageHeaderText = actualPageHeader.getText();
        Assertions.assertEquals("Введите адрес электронной почты", actualPageHeaderText.trim(), "Не совпадает надпись с сообщением об ошибке");
    }

    public void checkSomeField(String namePath, String value) {
        WebElement actualPageHeader = driver.findElement(By.xpath(namePath));
        wait.until(ExpectedConditions.visibilityOf(actualPageHeader));
        String actualPageHeaderText = actualPageHeader.getAttribute("value");
        Assertions.assertEquals(value, actualPageHeaderText.trim(), "Не совпадают данные параметры с введеными в поле");
    }


    public void clickSomeField(String namePath, String value) {
        WebElement someElement = driver.findElement(By.xpath(namePath));
        wait.until(ExpectedConditions.visibilityOf(someElement));
        someElement.click();
        someElement.sendKeys(value);
    }

}
