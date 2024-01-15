package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.AboutPage;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.DownloadSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)

public class AboutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setUp() throws InterruptedException {
        DownloadSteps.appDownload();
        try {
            AuthorizationPage.title.check(matches(isDisplayed()));
        } catch (Exception e) {
            MainSteps.logOut();
            AuthorizationPage.title.check(matches(isDisplayed()));
        }
        AuthorizationSteps.validLogIn();
    }

    @Test
    @DisplayName("Наличие всех элементов раздела \"О приложении\"")
    public void shouldBeFullContentInAboutBlock() throws InterruptedException {
        MainSteps.openAboutPage();
        AboutSteps.checkThatAboutBlockContentIsFull();
    }
    @Test
    @DisplayName("Возвращение на главную")
    public void testCheckGoBackMainScreen() throws InterruptedException {
        MainSteps.openAboutPage();
        AboutSteps.goBack();
        MainSteps.checkThatMainBlockContentIsFull();
    }

    @Test
    @DisplayName("Переход к политике конфиденциальности по ссылке")
    public void shouldGoToPrivacyPolicy() throws InterruptedException {
        MainSteps.openAboutPage();
        AboutSteps.goToPrivacyPolicy();

        // Проверка, что страница загрузилась
        intended(AboutSteps.goToPrivacyPolicy());
        AboutPage.policyText.check(matches(isDisplayed()));
        //Фактически не загружается
    }

    @Test
    @DisplayName("Переход к пользовательскому соглашению по ссылке")
    public void shouldGoToUserAgreement() throws InterruptedException {
        MainSteps.openAboutPage();
        AboutSteps.goToTermsOfUse();

        // Проверка, что страница загрузилась
        intended(AboutSteps.goToTermsOfUse());
        AboutPage.termsOfUseText.check(matches(isDisplayed()));
        //Фактически не загружается
    }
}
