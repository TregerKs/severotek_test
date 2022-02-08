package ru.kseniya.framework.managers;

import ru.kseniya.framework.page.*;

public class PageManager {
    private static PageManager INSTANCE = null;
    private StartPage startPage;
    private AdminPage adminPage;
    private NewEntryPage newEntryPage;
    private BlogPage blogPage;
    private BlogAdminPage blogAdminPage;
    private AreYouSurePage areYouSurePage;


    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public AdminPage getAdminPage() {
        if (adminPage == null) {
            adminPage = new AdminPage();
        }
        return adminPage;
    }

    public NewEntryPage getNewEntryPage() {
        if (newEntryPage == null) {
            newEntryPage = new NewEntryPage();
        }
        return newEntryPage;
    }

    public BlogPage getBlogPage() {
        if (blogPage == null) {
            blogPage = new BlogPage();
        }
        return blogPage;
    }

    public BlogAdminPage getBlogAdminPage() {
        if (blogAdminPage == null) {
            blogAdminPage = new BlogAdminPage();
        }
        return blogAdminPage;
    }

    public AreYouSurePage getAreYouSurePage() {
        if (areYouSurePage == null) {
            areYouSurePage = new AreYouSurePage();
        }
        return areYouSurePage;
    }
}
