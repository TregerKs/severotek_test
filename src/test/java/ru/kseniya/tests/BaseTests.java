package ru.kseniya.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.kseniya.framework.managers.ConfProperties;
import ru.kseniya.framework.managers.DriverManager;
import ru.kseniya.framework.managers.InitManager;

public class BaseTests {

    private final DriverManager driverManager = DriverManager.getInstance();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initDriverSetting();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(ConfProperties.getProperty("pageTest"));
    }

    @AfterEach
    public void after() {
        driverManager.quitDriver();
    }
}
