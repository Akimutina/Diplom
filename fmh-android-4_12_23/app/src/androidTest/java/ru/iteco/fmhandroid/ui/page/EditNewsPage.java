package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class EditNewsPage {
    public static ViewInteraction titlePage = onView(withId(R.id.custom_app_bar_title_text_view));

    public static ViewInteraction categoryText =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction titleText = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction descriptionText =
            onView(withId(R.id.news_item_description_text_input_edit_text));

    public static ViewInteraction publicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction time = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction switcher = onView(withId(R.id.switcher));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));


    //Сообщение об ошибке
    public static ViewInteraction errorMessage = onView(withId(R.id.message));

    //Окно вопроса
    public static ViewInteraction okButtonMessage = onView(withText("OK"));
    public static ViewInteraction cancelButtonMessage = onView(withText("Отмена"));
}
