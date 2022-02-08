package ru.kseniya.framework.managers;

import java.time.Duration;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getInstance();

    public static void initDriverSetting() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
}