package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;

import ru.iteco.fmhandroid.ui.page.DownloadPage;

public class DownloadSteps {

    @Step("Наличие всех элементов экрана загрузки")
    public static void checkThatDownloadPageContentIsFull() {
        DownloadPage.splashImage.check(matches(isDisplayed()));
        DownloadPage.splashProgressIndicator.check(matches(isDisplayed()));
        DownloadPage.splashText.check(matches(isDisplayed()));
    }

    @Step("Загрузка приложения")
    public static void appDownload() throws InterruptedException {
        checkThatDownloadPageContentIsFull();
        Thread.sleep(7000);
    }
}
