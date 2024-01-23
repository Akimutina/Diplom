package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.page.QuotesPage;

public class QuotesSteps {

    public static void checkThatQuotesBlockContentIsFull() {
        Allure.step("Проверка, что в блоке с цитатами полный контент");
        QuotesPage.logo.check(matches(isDisplayed()));
        QuotesPage.title.check(matches(isDisplayed()));
        QuotesPage.ourMissionList.check(matches(isDisplayed()));
    }

    public static void checkQuote(int number) {
        Allure.step("Развернуть/свернуть цитату");
        QuotesPage.missionConstraintLayout.check(matches(isDisplayed()));
        QuotesPage.missionConstraintLayout.perform(actionOnItemAtPosition(number, click()));
    }

    public static void descriptionIsDisplay(String text) {
        Allure.step("Отображение дополнительной цитаты");
        onView(allOf(
                withId(R.id.our_mission_item_description_text_view),
                withText(text),
                isCompletelyDisplayed()))
                .check(matches(isDisplayed()));
    }
}
