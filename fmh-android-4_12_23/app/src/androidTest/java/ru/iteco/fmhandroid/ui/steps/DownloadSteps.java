package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.DownloadPage;

public class DownloadSteps {

    public static void checkThatDownloadPageContentIsFull() {
        Allure.step("Наличие всех элементов экрана загрузки");
        DownloadPage.splashImage.check(matches(isDisplayed()));
        DownloadPage.splashProgressIndicator.check(matches(isDisplayed()));
        DownloadPage.splashText.check(matches(isDisplayed()));
    }

}
