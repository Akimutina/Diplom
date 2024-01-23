package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.EditNewsPage;

public class EditNewsSteps {

    public static void checkThatEditNewsPageContentIsFull() {
        Allure.step("Проверка, что в окне Редактирования новости полный контент");
        EditNewsPage.titlePage.check(matches(isDisplayed()));
        EditNewsPage.categoryText.check(matches(isDisplayed()));
        EditNewsPage.titleText.check(matches(isDisplayed()));
        EditNewsPage.descriptionText.check(matches(isDisplayed()));
        EditNewsPage.publicationDate.check(matches(isDisplayed()));
        EditNewsPage.time.check(matches(isDisplayed()));
        EditNewsPage.switcher.check(matches(isDisplayed()));
        EditNewsPage.saveButton.check(matches(isDisplayed()));
        EditNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public static void fillInNewsCategoryField(String text) {
        Allure.step("Ввод данных в поле Категория");
        EditNewsPage.categoryText.perform(replaceText(text));
    }

    public static void fillInNewsTitleField(String text) {
        Allure.step("Ввод данных в поле Заголовок");
        EditNewsPage.titleText.perform(replaceText(text));
    }

    public static void fillInPublicDateField(String text) {
        Allure.step("Ввод данных в поле Дата публикации");
        EditNewsPage.publicationDate.perform(replaceText(text));
    }

    public static void fillInTimeField(String text) {
        Allure.step("Ввод данных в поле Время");
        EditNewsPage.time.perform(replaceText(text));
    }

    public static void fillInNewsDescriptionField(String text) {
        Allure.step("Ввод данных в поле Описание");
        EditNewsPage.descriptionText.perform(replaceText(text));
    }

    public static void EditNewsFields(String category, String title, String publicationDate,
                                      String publicationTime, String description) {
        Allure.step("Перезаполнение/редактирование данных новости");
        EditNewsSteps.fillInNewsCategoryField(category);
        EditNewsSteps.fillInNewsTitleField(title);
        EditNewsSteps.fillInNewsDescriptionField(description);
        EditNewsSteps.fillInPublicDateField(publicationDate);
        EditNewsSteps.fillInTimeField(publicationTime);
    }

    public static void changeStatus() {
        Allure.step("Поменять статус новости");
        EditNewsPage.switcher.perform(click());
    }

    public static void clickSaveButton() {
        Allure.step("Нажатие кнопки Сохранить");
        EditNewsPage.saveButton.perform(click());
    }

    public static void clickCancelButton() {
        Allure.step("Нажатие кнопки Отмена");
        EditNewsPage.cancelButton.perform(click());
    }

    public static void clickOKButton() {
        Allure.step("Нажатие кнопки ОК в сообщении");
        EditNewsPage.okButtonMessage.perform(click());
    }
}

