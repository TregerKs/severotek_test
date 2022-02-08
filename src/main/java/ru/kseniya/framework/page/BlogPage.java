package ru.kseniya.framework.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.kseniya.framework.managers.ConfProperties;

import java.util.List;

public class BlogPage extends BasePage {

    @FindBy(xpath = "//a[@class=\"entry_title\"]")
    private List<WebElement> listTitle;

    public BlogPage checkTitleEntry() {
        for (WebElement i : listTitle) {
            waitUtilElementToBeClickable(i);
            Assertions.assertEquals(i.getText(), title, "Статья с названием " + title + " не найдена");
            return pageManager.getBlogPage();
        }
        return pageManager.getBlogPage();
    }

    public BlogAdminPage goToBlogAdminPage() {
        driverManager.getDriver().get(ConfProperties.getProperty("pageAdminBlog"));
        return pageManager.getBlogAdminPage();
    }
}
