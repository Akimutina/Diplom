package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.MainPage;


public class MainSteps {

    public static void checkThatMainBlockContentIsFull() {
        Allure.step("Проверка, что в блоке \"Главная\" полный контент");
        MainPage.profileButton.check(matches(isDisplayed()));
        MainPage.menuButton.check(matches(isDisplayed()));
        MainPage.ourMissionButton.check(matches(isDisplayed()));
        MainPage.titleOfNewsContainer.check(matches(isDisplayed()));
        MainPage.allNewsButton.check(matches(isDisplayed()));
    }

    public static void openNewsPage() throws InterruptedException {
        Allure.step("Открытие раздела \"Новости\"");
        MainPage.menuButton.perform(click());
        MainPage.newsOfMenu.perform(click());
        Thread.sleep(3000);
    }

    public static void openAboutPage() throws InterruptedException {
        Allure.step("Открытие раздела \"О приложении\"");
        MainPage.menuButton.perform(click());
        MainPage.aboutOfMenu.perform(click());
        Thread.sleep(3000);
    }

    public static void openQuotesPage() throws InterruptedException {
        Allure.step("Открытие раздела \"Цитаты\"");
        MainPage.ourMissionButton.perform(click());
        Thread.sleep(3000);
    }

    public static void logOut() throws InterruptedException {
        Allure.step("Выход из профиля");
        MainPage.profileButton.perform(click());
        MainPage.logOutButton.perform(click());
        Thread.sleep(3000);
    }

    public static void openAllNews() {
        Allure.step("Переход ко всем новостям");
        MainPage.allNewsButton.perform(click());
    }
}
