package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.AboutPage;

public class AboutSteps {

    public static void checkThatAboutBlockContentIsFull() {
        Allure.step("Проверка, что в блоке \"О приложении\" полный контент");
        AboutPage.logo.check(matches(isDisplayed()));
        AboutPage.backButton.check(matches(isDisplayed()));
        AboutPage.versionTitleField.check(matches(isDisplayed()));
        AboutPage.versionNumberField.check(matches(isDisplayed()));
        AboutPage.policyText.check(matches(isDisplayed()));
        AboutPage.termsOfUseText.check(matches(isDisplayed()));
        AboutPage.infoCompany.check(matches(isDisplayed()));
        AboutPage.privacyPolicyValue.check(matches(isDisplayed()));
        AboutPage.termsOfUseValue.check(matches(isDisplayed()));
    }

    public static void goBack() {
        Allure.step("Назад на Главную страницу");
        AboutPage.backButton.perform(click());
    }

    public static void goToPrivacyPolicy() {
        Allure.step("Переход к политике конфиденциальности");
        AboutPage.privacyPolicyValue.perform(click());

    }

    public static void goToTermsOfUse() {
        Allure.step("Переход к пользовательскому соглашению");
        AboutPage.termsOfUseValue.perform(click());
    }
}
