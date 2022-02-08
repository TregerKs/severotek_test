package ru.kseniya.framework.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.kseniya.framework.managers.ConfProperties;

import java.util.List;

public class BlogAdminPage extends BasePage {
    @FindBy(xpath = "//tbody//a[@href]")
    private List<WebElement> listEntry;

    @FindBy(xpath = "//select[@name=\"action\"]")
    private WebElement select;

    @FindBy(xpath = "//select[@name=\"action\"]//option[@value=\"delete_selected\"]")
    private WebElement delete;

    @FindBy(xpath = "//button[@type=\"submit\" and @class=\"button\"]")
    private WebElement actionButton;


    @Step("Переходим на страницу блога")
    public BlogPage goToBlogPage() {
        driverManager.getDriver().get(ConfProperties.getProperty("pageBlog"));
        return pageManager.getBlogPage();
    }

    @Step("Находим статью '{name}'")
    public BlogAdminPage findEntry(String name) {
        for (WebElement i : listEntry) {
            waitUtilElementToBeClickable(i);
            if (i.getText().equals(name)) {
                WebElement toClick = i.findElement(By.xpath("./../..//td[@class=\"action-checkbox\"]"));
                waitUtilElementToBeClickable(toClick);
                toClick.click();
                return pageManager.getBlogAdminPage();
            }
        }
        return pageManager.getBlogAdminPage();
    }

    @Step("Выбираем статью галочкой")
    public BlogAdminPage selectClick() {
        waitUtilElementToBeClickable(select).click();
        return pageManager.getBlogAdminPage();
    }

    @Step("Удаляем статью")
    public AreYouSurePage deleteEntry() {
        waitUtilElementToBeVisible(delete).click();
        waitUtilElementToBeClickable(actionButton).click();
        return pageManager.getAreYouSurePage();
    }
}
