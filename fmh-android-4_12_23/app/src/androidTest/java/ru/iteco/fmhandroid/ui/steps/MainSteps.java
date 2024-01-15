package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.page.MainPage;

public class MainSteps {

    @Step("Проверка, что в блоке \"Главная\" полный контент")
    public static void checkThatMainBlockContentIsFull() {
        MainPage.profileButton.check(matches(isDisplayed()));
        MainPage.menuButton.check(matches(isDisplayed()));
        MainPage.ourMissionButton.check(matches(isDisplayed()));
        MainPage.titleOfNewsContainer.check(matches(isDisplayed()));
        MainPage.allNewsButton.check(matches(isDisplayed()));
    }

    @Step("Открытие раздела \"Новости\"")
    public static void openNewsPage() throws InterruptedException {
        MainPage.menuButton.perform(click());
        MainPage.newsOfMenu.perform(click());
        Thread.sleep(3000);
    }

    @Step("Открытие раздела \"О приложении\"")
    public static void openAboutPage() throws InterruptedException {
        MainPage.menuButton.perform(click());
        MainPage.aboutOfMenu.perform(click());
        Thread.sleep(3000);
    }

    @Step("Выход из профиля")
    public static void logOut() throws InterruptedException {
        MainPage.profileButton.perform(click());
        MainPage.logOutButton.perform(click());
        Thread.sleep(3000);
    }
}
