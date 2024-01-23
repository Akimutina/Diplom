package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.Rand.randomCategory;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.getCurrentDate;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.getCurrentTime;

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
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.EditNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AANewsTest {

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
            MainPage.allNewsButton.check(matches(isDisplayed()));
        } catch (Exception e) {
            AuthorizationSteps.validLogIn();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход ко всем новостям с главной страницы")
    public void shouldOpenAllNews() {
        MainSteps.openAllNews();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Развернуть новость на главной странице")
    public void ExpandNewsOnTheMainPage() {
        NewsSteps.clickOneNewsItem(0);
    // Проверка???
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Наличие всех элементов на странице Новости")
    public void shouldBeFullContentInNewsPage() throws InterruptedException {
        MainSteps.openNewsPage();
        NewsSteps.checkThatNewsBlockContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход на страницу Панели управления и Наличие всех элементов")
    public void shouldOpenControlPanelPage() throws InterruptedException {
        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.checkThatControlPanelContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Возврат на Главную страницу со страницы Новости")
    public void shouldOpenMainPageFromNewsPage() throws InterruptedException {
        MainSteps.openNewsPage();
        NewsSteps.checkThatNewsBlockContentIsFull();
        NewsSteps.checkGoBackMainPage();
        MainSteps.checkThatMainBlockContentIsFull();
    }

    // СОЗДАНИЕ НОВОСТИ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход к созданию новости и Наличие всех элементов")
    public void shouldOpenCreateNews() throws InterruptedException {
        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openCreateNewsButton();
        Thread.sleep(2000);
        CreateNewsSteps.checkThatCreateNewsPageContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Cоздание новости с валидными данными")
    public void shouldCreateNewsValid() throws InterruptedException {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость от Aki тест";
        String description = "Описание новости от Aki тест";

        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openCreateNewsButton();

        //Создание
        CreateNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        CreateNewsSteps.clickSaveButton();
        Thread.sleep(3000);

        //Проверка, что новость создана
        ControlPanelSteps.checkIfNewsWithTitle(title);
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Cоздание новости с пустыми данными")
    public void shouldCreateEmptyNews() throws InterruptedException {

        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openCreateNewsButton();
        CreateNewsSteps.clickSaveButton();

        //Проверка сообщения
        CreateNewsSteps.checkToastMessageText("Заполните пустые поля", decorView);
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Отменить создание новости")
    public void shouldCancelCreateNews() throws InterruptedException {
        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openCreateNewsButton();
        //Thread.sleep(3000);

        //Отмена
        CreateNewsSteps.clickCancelButton();
        CreateNewsSteps.clickOKButton();
        Thread.sleep(3000);
        ControlPanelSteps.checkThatControlPanelContentIsFull();
    }

    // УДАЛЕНИЕ НОВОСТИ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Удаление новости")
    public void shouldDeleteNews() throws InterruptedException {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость от Aki Delete";
        String description = "Описание новости от Aki Delete";

        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openCreateNewsButton();

        CreateNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        CreateNewsSteps.clickSaveButton();
        Thread.sleep(2000);

        ControlPanelSteps.clickDeleteNews(title);
        ControlPanelSteps.checkIfNoNewsWithTitle(title);
    }

    // РЕДАКТИРОВАНИЕ НОВОСТИ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Редактирование новости")
    public void shouldEditNews() throws InterruptedException {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость";
        String description = "Описание новости";
        String newTitle = "Новость от Aki средактирована";
        String newDescription = "Описание новости от Aki средактирована";

        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openCreateNewsButton();
        CreateNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        CreateNewsSteps.clickSaveButton();
        Thread.sleep(2000);

        //Редактирование
        ControlPanelSteps.clickEditNews(title);
        EditNewsSteps.checkThatEditNewsPageContentIsFull();

        EditNewsSteps.EditNewsFields(randomCategory(), newTitle, publicationDate,
                publicationTime, newDescription);
        EditNewsSteps.changeStatus();
        EditNewsSteps.clickSaveButton();
        Thread.sleep(3000);

        //Проверка по заголовку
        ControlPanelSteps.checkIfNewsWithTitle(newTitle);
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Отмена редактирования новости")
    public void shouldCancelEditNews() throws InterruptedException {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость 2";
        String description = "Описание новости 2";

        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openCreateNewsButton();
        CreateNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        CreateNewsSteps.clickSaveButton();
        Thread.sleep(2000);

        //Редактирование
        ControlPanelSteps.clickEditNews(title);
        EditNewsSteps.checkThatEditNewsPageContentIsFull();
        EditNewsSteps.changeStatus();

        //Отмена
        EditNewsSteps.clickCancelButton();
        EditNewsSteps.clickOKButton();
        Thread.sleep(3000);
        ControlPanelSteps.checkThatControlPanelContentIsFull();
    }

    // ФИЛЬТРАЦИЯ НОВОСТЕЙ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Выход из фильтра без фильтрации новостей")
    public void testCancelingFiltering() throws InterruptedException {
        MainSteps.openNewsPage();
        ControlPanelSteps.openControlPanelPage();
        ControlPanelSteps.openNewsFilter();
        FilterNewsSteps.clickCancelButton();
        ControlPanelSteps.checkThatControlPanelContentIsFull();
    }
}
