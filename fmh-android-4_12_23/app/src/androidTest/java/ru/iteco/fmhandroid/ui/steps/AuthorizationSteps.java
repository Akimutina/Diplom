package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import android.view.View;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.activity.DataHelper;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;

public class AuthorizationSteps {

    @Step("Наличие всех элементов формы авторизации")
    public static void checkThatAuthorizationBlockContentIsFull() {
        AuthorizationPage.title.check(matches(isDisplayed()));
        AuthorizationPage.loginField.check(matches(isDisplayed()));
        AuthorizationPage.passwordField.check(matches(isDisplayed()));
        AuthorizationPage.loginButton.check(matches(isDisplayed()));
    }

    @Step("Авторизация в приложении под валидными данным")
    public static void validLogIn() throws InterruptedException {
        DataHelper help = new DataHelper();
        AuthorizationPage.loginField.perform(typeText(help.getValidUser().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(help.getValidUser().getPassword()), closeSoftKeyboard());
        AuthorizationPage.loginButton.perform(click());
        Thread.sleep(2000);
    }

    @Step("Авторизация в приложении под НЕвалидными данным")
    public static void notValidLogIn() throws InterruptedException {
        DataHelper helper = new DataHelper();
        AuthorizationPage.loginField.perform(typeText(helper.getNotValidUser().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(helper.getNotValidUser().getPassword()), closeSoftKeyboard());
        AuthorizationPage.loginButton.perform(click());
        Thread.sleep(1000);
    }

    @Step("Авторизация в приложении с пустыми данным")
    public static void emptyLogIn() throws InterruptedException {
        AuthorizationPage.loginButton.perform(click());
        Thread.sleep(1000);
    }

    public static void checkToastMessageText(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}
