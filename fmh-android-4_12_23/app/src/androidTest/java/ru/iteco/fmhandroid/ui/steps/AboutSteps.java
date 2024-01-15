package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.content.Intent;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.page.AboutPage;

public class AboutSteps {

    @Step("Проверка, что в блоке \"О приложении\" полный контент")
    public static void checkThatAboutBlockContentIsFull() {
        AboutPage.logo.check(matches(isDisplayed()));
        AboutPage.backButton.check(matches(isDisplayed()));
        AboutPage.versionTitleField.check(matches(isDisplayed()));
        AboutPage.versionNumberField.check(matches(isDisplayed()));
        AboutPage.infoCompany.check(matches(isDisplayed()));
        AboutPage.policyText.check(matches(isDisplayed()));
        AboutPage.termsOfUseText.check(matches(isDisplayed()));
    }

    @Step("Назад на Главную страницу")
    public static void goBack() {
        AboutPage.backButton.perform(click());
    }

    @Step("Переход к политике конфиденциальности")
    public static Matcher<Intent> goToPrivacyPolicy() {
        AboutPage.privacyPolicyValue.perform(click());
        return Matchers.allOf(Matchers.any(Intent.class), hasData("https://vhospice.org/#/privacy-policy"));
    }

    @Step("Переход к пользовательскому соглашению")
    public static Matcher<Intent> goToTermsOfUse() {
        AboutPage.termsOfUseValue.perform(click());
        return Matchers.allOf(Matchers.any(Intent.class), hasData("https://vhospice.org/#/terms-of-use"));
    }
}
