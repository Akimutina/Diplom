package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsMainPage {
    public static ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction title = onView(withText("Новости"));
    public static ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public static ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction controlPanelButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction addNews = onView(withId(R.id.add_news_image_view));

    //public static ViewInteraction newsContainerLayout = onView(withId(R.id.news_item_material_card_view));
}
