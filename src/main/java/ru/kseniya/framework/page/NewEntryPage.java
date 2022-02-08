package ru.kseniya.framework.page;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewEntryPage extends BasePage {
    private String randomString;

    @FindBy(xpath = "//input[@class=\"vTextField\"]")
    private List<WebElement> listField;

    @FindBy(xpath = "//textarea[@class=\"vLargeTextField\"]")
    private List<WebElement> ListTextarea;

    @FindBy(xpath = "//input[@type=\"submit\" and @value=\"Сохранить\"]")
    private WebElement save;

    @Step("Проверяем заголовок")
    public NewEntryPage assertTitleEntry() {
        Assertions.assertTrue(driverManager.getDriver().getTitle().contains("Добавить entry"), "Неправильный заголовок");
        return pageManager.getNewEntryPage();
    }

    @Step("Заполняем поле '{name}'")
    public NewEntryPage enterField(String name) {
        for (WebElement i : listField) {
            waitUtilElementToBeClickable(i);
            if (i.getAttribute("name").contains(name)) {
                fillInputField(i, fillingLine(name));
                if (name.equals("title")) {
                    title = randomString;
                }
                return pageManager.getNewEntryPage();
            }
        }
        return pageManager.getNewEntryPage();
    }

    @Step("Заполняем поле '{name}'")
    public NewEntryPage enterText(String name) {
        for (WebElement i : ListTextarea) {
            waitUtilElementToBeClickable(i);
            if (i.getAttribute("name").equals(name)) {
                fillInputField(i, fillingLine(name));
                return pageManager.getNewEntryPage();
            }
        }
        return pageManager.getNewEntryPage();
    }

    @Step("Генерируем случайное значение")
    public String fillingLine(String name) {
        Faker faker = new Faker();
        randomString = name + faker.number().numberBetween(1000, 10000);
        return randomString;
    }

    @Step("Нажимаем 'сохранить'")
    public BlogAdminPage clickSave() {
        waitUtilElementToBeClickable(save).click();
        return pageManager.getBlogAdminPage();
    }
}
