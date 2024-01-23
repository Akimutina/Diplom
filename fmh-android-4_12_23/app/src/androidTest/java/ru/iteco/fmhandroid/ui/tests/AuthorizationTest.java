package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.CoreMatchers.not;

import android.view.View;

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
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    private View decorView;

    @Before
    public void setUp() throws InterruptedException {
        Thread.sleep(5000);
        try {
            AuthorizationPage.title.check(matches(isDisplayed()));
        } catch (
                Exception e) {
            MainSteps.logOut();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    @Feature(value = "Тесты по странице Авторизации")
    @Story("Наличие всех элементов формы авторизации")
    public void shouldBeFullContentInAboutBlock() {
        AuthorizationSteps.checkThatAuthorizationBlockContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по странице Авторизации")
    @Story("Авторизация в приложении под валидными данными")
    public void shouldLoginByValidUser() throws InterruptedException {
        AuthorizationSteps.validLogIn();
        MainSteps.checkThatMainBlockContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по странице Авторизации")
    @Story("Авторизация в приложении под НЕ валидными данными")
    public void shouldLoginByNotValidUser() {
        AuthorizationSteps.notValidLogIn();

        //Проверка сообщения:
        AuthorizationSteps.checkToastMessageText("Не верный логин или пароль", decorView);
        //Верное сообщение: "Не верный логин или пароль"
        //Фактическое сообщение: "Что-то пошло не так. Попробуйте позднее."

        AuthorizationPage.title.check(matches(isDisplayed()));
        MainPage.mainLogo.check(matches(not(isDisplayed())));
    }

    @Test
    @Feature(value = "Тесты по странице Авторизации")
    @Story("Авторизация в приложении с пустыми данными")
    public void shouldLoginByEmptyUser() {
        AuthorizationSteps.emptyLogIn();

        //Проверка сообщения:
        AuthorizationSteps.checkToastMessageText("Логин и пароль не могут быть пустыми", decorView);

        AuthorizationPage.title.check(matches(isDisplayed()));
        MainPage.mainLogo.check(matches(not(isDisplayed())));
    }

    @Test
    @Feature(value = "Тесты по странице Авторизациии")
    @Story("Выход из учётной записи")
    public void shouldLogoff() throws InterruptedException {
        AuthorizationSteps.validLogIn();
        MainSteps.logOut();
        Thread.sleep(3000);
        AuthorizationSteps.checkThatAuthorizationBlockContentIsFull();
    }
}