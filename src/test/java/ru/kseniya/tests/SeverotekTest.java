package ru.kseniya.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kseniya.framework.managers.PageManager;
import ru.kseniya.framework.page.BasePage;

public class SeverotekTest extends BaseTests {

    @Test
    @DisplayName("Тестирование сайта 'igorakintev.ru'")
    public void test() {
        PageManager.getInstance().getStartPage().inputLogin("selenium")
                .inputPassword("super_password")
                .clickSubmit()
                .assertTitle()
                .clickAddEntryButton()
                .assertTitleEntry()
                .enterField("title")
                .enterField("slug")
                .enterText("text_markdown")
                .enterText("text")
                .clickSave()
                .goToBlogPage()
                .checkTitleEntry()
                .goToBlogAdminPage()
                .findEntry(BasePage.title)
                .selectClick()
                .deleteEntry()
                .clickAgree();
    }
}
