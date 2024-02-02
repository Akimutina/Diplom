package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.DownloadSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;


@RunWith(AllureAndroidJUnit4.class)

public class AboutTest {
    DownloadSteps downloadSteps = new DownloadSteps();
    AboutSteps aboutSteps = new AboutSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainPage mainPage = new MainPage();
    MainSteps mainSteps = new MainSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setUp() {
        downloadSteps.appDownload();
        try {
            mainPage.allNewsButton.check(matches(isDisplayed()));
        } catch (Exception e) {
            authorizationSteps.validLogIn();
        }
    }

    @Test
    @Feature(value = "Тесты по странице \"О приложении\"")
    @DisplayName("Наличие всех элементов страницы")
    public void shouldBeFullContentInAboutBlock() throws InterruptedException {
        mainSteps.openAboutPage();
        aboutSteps.checkThatAboutBlockContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по странице \"О приложении\"")
    @DisplayName("Возвращение на главную")
    public void shouldGoBackMainPage() throws InterruptedException {
        mainSteps.openAboutPage();
        aboutSteps.goBack();
        mainSteps.checkThatMainBlockContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по странице \"О приложении\"")
    @DisplayName("Переход к странице \"О приложении\", находясь на странице \"Новости\"")
    public void shouldOpenAboutPageFromNewsPage() throws InterruptedException {
        mainSteps.openNewsPage();
        mainSteps.openAboutPage();
        aboutSteps.checkThatAboutBlockContentIsFull();
        //Фактически кнопка не активна, нельзя перейти
    }

    @Test
    @Feature(value = "Тесты по странице \"О приложении\"")
    @DisplayName("Переход к политике конфиденциальности по ссылке")
    public void shouldGoToPrivacyPolicy() throws InterruptedException {
        mainSteps.openAboutPage();
        aboutSteps.goToPrivacyPolicy();
        //Ссылка кликабельна, но страница фактически не загружается
        pressBack();
    }

    @Test
    @Feature(value = "Тесты по странице \"О приложении\"")
    @DisplayName("Переход к пользовательскому соглашению по ссылке")
    public void shouldGoToUserAgreement() throws InterruptedException {
        mainSteps.openAboutPage();
        aboutSteps.goToTermsOfUse();
        //Ссылка кликабельна, но страница фактически не загружается
        pressBack();
    }
}