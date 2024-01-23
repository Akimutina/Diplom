package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.CreateNewsPage;

public class CreateNewsSteps {

    public static void checkThatCreateNewsPageContentIsFull() {
        Allure.step("Проверка, что в окне Создания новости полный контент");
        CreateNewsPage.titlePage.check(matches(isDisplayed()));
        CreateNewsPage.categoryText.check(matches(isDisplayed()));
        CreateNewsPage.titleText.check(matches(isDisplayed()));
        CreateNewsPage.descriptionText.check(matches(isDisplayed()));
        CreateNewsPage.publicationDate.check(matches(isDisplayed()));
        CreateNewsPage.time.check(matches(isDisplayed()));
        CreateNewsPage.switcher.check(matches(isDisplayed()));
        CreateNewsPage.saveButton.check(matches(isDisplayed()));
        CreateNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public static void fillInNewsCategoryField(String text) {
        Allure.step("Ввод данных в поле Категория");
        CreateNewsPage.categoryText.perform(replaceText(text));
    }

    public static void fillInNewsTitleField(String text) {
        Allure.step("Ввод данных в поле Заголовок");
        CreateNewsPage.titleText.perform(replaceText(text));
    }

    public static void fillInPublicDateField(String text) {
        Allure.step("Ввод данных в поле Дата публикации");
        CreateNewsPage.publicationDate.perform(replaceText(text));
    }

    public static void fillInTimeField(String text) {
        Allure.step("Ввод данных в поле Время");
        CreateNewsPage.time.perform(replaceText(text));
    }

    public static void fillInNewsDescriptionField(String text) {
        Allure.step("Ввод данных в поле Описание");
        CreateNewsPage.descriptionText.perform(replaceText(text));
    }

    public static void createNews(String category, String title, String publicationDate,
                                  String publicationTime, String description) {
        Allure.step("Ввод данных для создания новости");
        fillInNewsCategoryField(category);
        fillInNewsTitleField(title);
        fillInPublicDateField(publicationDate);
        fillInTimeField(publicationTime);
        fillInNewsDescriptionField(description);
    }

    public static void clickSaveButton() {
        Allure.step("Нажатие кнопки Сохранить");
        CreateNewsPage.saveButton.perform(click());
    }

    public static void clickCancelButton() {
        Allure.step("Нажатие кнопки Отмена");
        CreateNewsPage.cancelButton.perform(click());
    }

    public static void clickOKButton() {
        Allure.step("Нажатие кнопки ОК в сообщении");
        CreateNewsPage.okButtonMessage.perform(click());
    }

    public static void checkToastMessageText(String text, View decorView) {
        Allure.step("Проверка сообщения");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

}
