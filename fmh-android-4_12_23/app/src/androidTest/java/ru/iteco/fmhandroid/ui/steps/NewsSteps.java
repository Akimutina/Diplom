package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.activity.DataHelper;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.page.NewsMainPage;

public class NewsSteps {

    public static void checkThatNewsBlockContentIsFull() {
        Allure.step("Проверка, что в блоке новостей полный контент");
        NewsMainPage.logo.check(matches(isDisplayed()));
        NewsMainPage.title.check(matches(isDisplayed()));
        NewsMainPage.sort.check(matches(isDisplayed()));
        NewsMainPage.filter.check(matches(isDisplayed()));
        NewsMainPage.controlPanelButton.check(matches(isDisplayed()));
        NewsMainPage.allNewsBlock.check(matches(isDisplayed()));
    }

    public static void checkGoBackMainPage() throws InterruptedException {
        Allure.step("Возврат на Главную страницу со страницы Новости");
        MainPage.menuButton.perform(click());
        MainPage.mainOfMenu.perform(click());
        Thread.sleep(3000);
    }

    public static void clickSortNewsButton() {
        Allure.step("Нажать кнопку сортировки");
        NewsMainPage.sort.perform(click());
    }

    public static void openNewsFilter() {
        Allure.step("Открыть расширенный фильтр");
        NewsMainPage.filter.perform(click());
    }

    public static void clickOneNewsItem(int index) {
        Allure.step("Развернуть/свернуть новость");
        NewsMainPage.childNewsButton.perform(actionOnItemAtPosition(index, click()));
    }

    public static String getFirstNewsTitle(int index) {
        Allure.step("Заголовок первой новости");
        return DataHelper.Text.getText(onView(withIndex(withId(R.id.news_item_title_text_view), index)));
    }

    public static String getCreateNewsDescription(int index) {
        Allure.step("Описание созданной новости");
        return DataHelper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), index)));
    }
}
