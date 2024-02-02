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
import ru.iteco.fmhandroid.ui.steps.DownloadSteps;
import ru.iteco.fmhandroid.ui.steps.EditNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AANewsTest {

    DownloadSteps downloadSteps = new DownloadSteps();
    MainPage mainPage = new MainPage();
    MainSteps mainSteps = new MainSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    NewsSteps newsSteps = new NewsSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();
    EditNewsSteps editNewsSteps = new EditNewsSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    private View decorView;

    @Before
    public void setUp() {
        downloadSteps.appDownload();
        try {
            mainPage.allNewsButton.check(matches(isDisplayed()));
        } catch (Exception e) {
            authorizationSteps.validLogIn();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход ко всем новостям с главной страницы")
    public void shouldOpenAllNews() {
        mainSteps.openAllNews();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Развернуть новость на главной странице")
    public void ExpandNewsOnTheMainPage() {
        newsSteps.clickOneNewsItem(0);
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Наличие всех элементов на странице Новости")
    public void shouldBeFullContentInNewsPage() {
        mainSteps.openNewsPage();
        newsSteps.checkThatNewsBlockContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход на страницу Панели управления и Наличие всех элементов")
    public void shouldOpenControlPanelPage() {
        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.checkThatControlPanelContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Возврат на Главную страницу со страницы Новости")
    public void shouldOpenMainPageFromNewsPage() {
        mainSteps.openNewsPage();
        newsSteps.checkThatNewsBlockContentIsFull();
        newsSteps.checkGoBackMainPage();
        mainSteps.checkThatMainBlockContentIsFull();
    }

    // СОЗДАНИЕ НОВОСТИ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход к созданию новости и Наличие всех элементов")
    public void shouldOpenCreateNews() {
        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.checkThatCreateNewsPageContentIsFull();
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Cоздание новости с валидными данными")
    public void shouldCreateNewsValid() {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость от Aki тест";
        String description = "Описание новости от Aki тест";

        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openCreateNewsButton();

        //Создание
        createNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        createNewsSteps.clickSaveButton();

        //Проверка, что новость создана
        controlPanelSteps.checkIfNewsWithTitle(title);
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Cоздание новости с пустыми данными")
    public void shouldCreateEmptyNews() {

        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.clickSaveButton();

        //Проверка сообщения
        createNewsSteps.checkToastMessageText("Заполните пустые поля", decorView);
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Отменить создание новости")
    public void shouldCancelCreateNews() {
        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openCreateNewsButton();

        //Отмена
        createNewsSteps.clickCancelButton();
        createNewsSteps.clickOKButton();
        controlPanelSteps.checkThatControlPanelContentIsFull();
    }

    // УДАЛЕНИЕ НОВОСТИ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Удаление новости")
    public void shouldDeleteNews() {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость от Aki Delete";
        String description = "Описание новости от Aki Delete";

        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openCreateNewsButton();

        createNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        createNewsSteps.clickSaveButton();

        controlPanelSteps.clickDeleteNews(title);
        controlPanelSteps.checkIfNoNewsWithTitle(title);
    }

    // РЕДАКТИРОВАНИЕ НОВОСТИ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Редактирование новости")
    public void shouldEditNews() {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость";
        String description = "Описание новости";
        String newTitle = "Новость от Aki средактирована";
        String newDescription = "Описание новости от Aki средактирована";

        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        createNewsSteps.clickSaveButton();

        //Редактирование
        controlPanelSteps.clickEditNews(title);
        editNewsSteps.checkThatEditNewsPageContentIsFull();

        editNewsSteps.EditNewsFields(randomCategory(), newTitle, publicationDate,
                publicationTime, newDescription);
        editNewsSteps.changeStatus();
        editNewsSteps.clickSaveButton();

        //Проверка по заголовку
        controlPanelSteps.checkIfNewsWithTitle(newTitle);
    }

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Отмена редактирования новости")
    public void shouldCancelEditNews() {

        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String title = "Новость 2";
        String description = "Описание новости 2";

        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openCreateNewsButton();
        createNewsSteps.createNews(randomCategory(), title, publicationDate,
                publicationTime, description);
        createNewsSteps.clickSaveButton();

        //Редактирование
        controlPanelSteps.clickEditNews(title);
        editNewsSteps.checkThatEditNewsPageContentIsFull();
        editNewsSteps.changeStatus();

        //Отмена
        editNewsSteps.clickCancelButton();
        editNewsSteps.clickOKButton();
        controlPanelSteps.checkThatControlPanelContentIsFull();
    }

    // ФИЛЬТРАЦИЯ НОВОСТЕЙ

    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Выход из фильтра без фильтрации новостей")
    public void testCancelingFiltering() {
        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openNewsFilter();
        filterNewsSteps.clickCancelButton();
        controlPanelSteps.checkThatControlPanelContentIsFull();
    }
}
