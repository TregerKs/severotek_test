package ru.kseniya.framework.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AreYouSurePage extends BasePage {
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement agree;

    @Step("Подтверждаем удаление статьи")
    public BlogAdminPage clickAgree() {
        waitUtilElementToBeClickable(agree).click();
        return pageManager.getBlogAdminPage();
    }
}
