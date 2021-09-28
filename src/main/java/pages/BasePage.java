package pages;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver = DriverManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 5, 5000);
    ;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWaiter() {
        return wait;
    }

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }
}
