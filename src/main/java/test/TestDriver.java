package test;


import consts.AdressRgsUrl;
import framework.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import pages.*;

import java.util.stream.Stream;

//import pages.FillingFields;
@RunWith(Parameterized.class)
public class TestDriver extends BasePage {

    public static Stream<Arguments> zayavkaParams() {
        return Stream.of(
                Arguments.of("Фамилия", "Имя", "Матчество"),
                Arguments.of("Фамилия", "Имя", "Матчество"),
                Arguments.of("Фамилия", "Имя", "Матчество"));
    }

    @BeforeEach
    public void setUp() {
        driver.get(AdressRgsUrl.BASE_URL.getBaseUrl());
    }

    @AfterEach
    public void tearDown() {
        DriverManager.closeDriver();
    }

    @ParameterizedTest
    @MethodSource("zayavkaParams")
    public void theRgsTestingWithVariants(String name, String surName, String middleName) {
        NavigatorRgs navigatorRgs = new NavigatorRgs(DriverManager.getDriver());
        PathToVoluntaryHealthInsurance pathToHealth = new PathToVoluntaryHealthInsurance(driver);
        DmsPage dmsPage = new DmsPage(driver);
        FillingFields fillingFields = new FillingFields(driver);

        navigatorRgs.clickCookiesButton();
        navigatorRgs.clickMenuButton();
        pathToHealth.clickCompanies();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,450)");

        pathToHealth.UntilHealthButtonVisible();
        pathToHealth.dmsButtonElement();
        dmsPage.containsDms();
        dmsPage.clickHealthButton();
        dmsPage.clickWindowDms();
        dmsPage.containsApplicationDms();

        fillingFields.clickSomeField(FillingFields.LAST_NAME_LOC, surName);
        fillingFields.clickSomeField(FillingFields.FIRST_NAME_LOC, name);
        fillingFields.clickSomeField(FillingFields.MIDDLE_NAME_LOC, middleName);
        fillingFields.clickSomeField(FillingFields.PHONE_NUMBER_LOC, "8005553535");
        fillingFields.clickSomeField(FillingFields.DATE_CONNECTION_LOC, "12.12.2021");
        fillingFields.clickSomeField(FillingFields.COMMENT_LOC, "У нас было 2 пакета травы, 75 таблеток мескалина, 5 упаковок кислоты, полсолонки кокаина и целое множество транквилизаторов всех сортов");
        fillingFields.clickSomeField(FillingFields.MAIL_LOC, "qwertyqwerty");
        fillingFields.clickSomeField(FillingFields.CLICK_REGION_LOC, "Москва");
        fillingFields.checkSomeField(FillingFields.LAST_NAME_LOC, surName);
        fillingFields.checkSomeField(FillingFields.FIRST_NAME_LOC, name);
        fillingFields.checkSomeField(FillingFields.MIDDLE_NAME_LOC, middleName);
        fillingFields.checkSomeField(FillingFields.PHONE_NUMBER_LOC, "+7 (800) 555-35-35");
        fillingFields.checkSomeField(FillingFields.COMMENT_LOC, "У нас было 2 пакета травы, 75 таблеток мескалина, 5 упаковок кислоты, полсолонки кокаина и целое множество транквилизаторов всех сортов");
        fillingFields.checkSomeField(FillingFields.DATE_CONNECTION_LOC, "12.12.2021");
        fillingFields.checkSomeField(FillingFields.MAIL_LOC, "qwertyqwerty");
        fillingFields.onlyClickField(FillingFields.CLICK_SPACE_LOC);
        fillingFields.onlyClickField(FillingFields.OK_LOC);
        fillingFields.onlyClickField(FillingFields.OK_SPACE_LOC);
        fillingFields.clickCheckboxField();
        fillingFields.checkOkField();
    }
}
