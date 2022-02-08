package ru.kseniya.framework.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//input[@id=\"id_username\"]")
    private WebElement login;

    @FindBy(xpath = "//input[@id=\"id_password\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement submit;

    @Step("Вводим {name} в строку")
    public StartPage inputLogin(String name) {
        waitUtilElementToBeVisible(login);
        fillInputField(login, name);
        return pageManager.getStartPage();
    }

    @Step("Вводим {password} в строку")
    public StartPage inputPassword(String password) {
        waitUtilElementToBeVisible(this.password);
        fillInputField(this.password, password);
        return pageManager.getStartPage();
    }

    @Step("Нажимаем кнопку войти")
    public AdminPage clickSubmit() {
        waitUtilElementToBeClickable(submit).click();
        return pageManager.getAdminPage();
    }
}
