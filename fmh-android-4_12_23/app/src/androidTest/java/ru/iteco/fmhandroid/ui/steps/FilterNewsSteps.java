package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.CreateNewsPage;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;

public class FilterNewsSteps {

    public static void checkThatFilterNewsBlockContentIsFull() {
        Allure.step("Проверка, что в блоке Фильтрации новостей полный контент");
        FilterNewsPage.titlePage.check(matches(isDisplayed()));
        FilterNewsPage.categoryText.check(matches(isDisplayed()));
        FilterNewsPage.dateStartText.check(matches(isDisplayed()));
        FilterNewsPage.dateEndText.check(matches(isDisplayed()));
        FilterNewsPage.filterActive.check(matches(isDisplayed()));
        FilterNewsPage.filterNotActive.check(matches(isDisplayed()));
        FilterNewsPage.filterButton.check(matches(isDisplayed()));
        FilterNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public static void clickFilterButton() {
        Allure.step("Нажатие кнопки Фильтровать");
        FilterNewsPage.filterButton.perform(click());
    }

    public static void clickCancelButton() {
        Allure.step("Нажатие кнопки Отмена");
        FilterNewsPage.cancelButton.perform(click());
    }

    public static void clickOKButton() {
        Allure.step("Нажатие кнопки ОК в сообщении");
        FilterNewsPage.okButtonMessage.perform(click());
    }

    public static void fillInStartDateField(String startDate) {
        Allure.step("Поле начальная дата - ввод данных");
        FilterNewsPage.dateStartText.perform(replaceText(startDate));
    }

    public static void fillInEndDateField(String endDate) {
        Allure.step("Поле конечная дата - ввод данных");
        FilterNewsPage.dateEndText.perform(replaceText(endDate));
    }

    public static void clickActiveCheckBox() {
        Allure.step("Нажать чекбокс - Active");
        FilterNewsPage.filterActive.perform(click());
    }

    public static void clickNotActiveCheckBox() {
        Allure.step("Нажать чекбокс - Not active");
        FilterNewsPage.filterNotActive.perform(click());
    }

    public static void checkBoxStatusActive(boolean checked) {
        Allure.step("Проверка нажатия - Active");

        if (checked) {
            FilterNewsPage.filterActive.check(matches(isChecked()));
        } else {
            FilterNewsPage.filterActive.check(matches(isNotChecked()));
        }
    }

    public static void checkBoxStatusNotActive(boolean checked) {
        Allure.step("Проверка нажатия - Not active");

        if (checked) {
            FilterNewsPage.filterNotActive.check(matches(isChecked()));
        } else {
            FilterNewsPage.filterNotActive.check(matches(isNotChecked()));
        }
    }

}
