package ru.kseniya.framework.page;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {

    @FindBy(xpath = "//a[@href=\"/admin/blog/entry/add/\"]")
    private WebElement addEntryButton;

    @Step("Проверяем заголовок")
    public AdminPage assertTitle() {
        Assertions.assertTrue(driverManager.getDriver().getTitle().contains("Панель управления"), "Неправильный заголовок");
        return pageManager.getAdminPage();
    }

    @Step("Нажимаем 'добавить' Entries")
    public NewEntryPage clickAddEntryButton() {
        waitUtilElementToBeClickable(addEntryButton).click();
        return pageManager.getNewEntryPage();
    }
}
