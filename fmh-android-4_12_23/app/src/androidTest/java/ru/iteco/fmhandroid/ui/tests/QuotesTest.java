package ru.iteco.fmhandroid.ui.tests;

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
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.DownloadSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)
public class QuotesTest {
    DownloadSteps downloadSteps = new DownloadSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainPage mainPage = new MainPage();
    MainSteps mainSteps = new MainSteps();
    QuotesSteps quotesSteps = new QuotesSteps();


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
        mainSteps.openQuotesPage();
    }

    @Test
    @Feature(value = "Тесты по странице с цитатами")
    @Story("Наличие всех элементов страницы")
    public void shouldBeFullContentInQuotesBlock() {
        quotesSteps.checkThatQuotesBlockContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по странице с цитатами")
    @Story("Развернуть цитату и свернуть")
    public void shouldBeDisplayQuote() {
        String quoteTestText = "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер";

        quotesSteps.checkQuote(0);
        quotesSteps.descriptionIsDisplay(quoteTestText);
        quotesSteps.checkQuote(0);
    }
}

