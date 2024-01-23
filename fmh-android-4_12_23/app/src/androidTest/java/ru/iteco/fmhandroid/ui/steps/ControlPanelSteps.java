package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.NewsMainPage;

public class ControlPanelSteps {

    public static void openControlPanelPage() throws InterruptedException {
        Allure.step("Переход в панель управления со страницы Новости");
        NewsMainPage.controlPanelButton.perform(click());
        Thread.sleep(2000);
    }

    public static void checkThatControlPanelContentIsFull() {
        Allure.step("Проверка, что в панели управления полный контент");
        ControlPanelPage.logo.check(matches(isDisplayed()));
        ControlPanelPage.sortButton.check(matches(isDisplayed()));
        ControlPanelPage.filterButton.check(matches(isDisplayed()));
        ControlPanelPage.addNewsButton.check(matches(isDisplayed()));
    }

    public static void clickSortNewsButton() throws InterruptedException {
        Allure.step("Нажать кнопку сортировки");
        ControlPanelPage.sortButton.perform(click());
        Thread.sleep(2000);
    }

    public static void openNewsFilter() throws InterruptedException {
        Allure.step("Открыть расширенный фильтр");
        ControlPanelPage.filterButton.perform(click());
        Thread.sleep(2000);
    }

    public static void openCreateNewsButton() throws InterruptedException {
        Allure.step("Нажать кнопку создание новости");
        ControlPanelPage.addNewsButton.perform(click());
        Thread.sleep(2000);
    }

    public static void clickDeleteNews(String newsTitle) throws InterruptedException {
        Allure.step("Удалить новость с указанным заголовком");
        ControlPanelPage.deleteNewsButton(newsTitle).perform(click());
        Thread.sleep(2000);
        CreateNewsSteps.clickOKButton();
    }

    public static void clickEditNews(String newsTitle) throws InterruptedException {
        Allure.step("Нажать кнопку Корректировка новости");
        ControlPanelPage.editNewsButton(newsTitle).perform(click());
        Thread.sleep(2000);
    }

    public static void checkIfNewsWithTitle(String titleText) {
        Allure.step("Проверка наличия новости с указанным заголовком");
        onView(allOf(withText(titleText), isDisplayed())).check(matches(isDisplayed()));
    }

    public static void checkIfNoNewsWithTitle(String titleText) {
        Allure.step("Проверка, что новости с указанным заголовком нет");
        onView(allOf(withText(titleText), isDisplayed())).check(doesNotExist());
    }


}
