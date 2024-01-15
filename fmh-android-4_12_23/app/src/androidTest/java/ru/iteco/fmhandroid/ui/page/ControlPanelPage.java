package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelPage {

    public static ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction titlePage = onView(withText("Панель управления"));

    //Меню панели управления
    public static ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public static ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction addNews = onView(withId(R.id.add_news_image_view));

    //Блок каждой новости
    public static ViewInteraction titleCategory = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction publicationDate = onView(withId(R.id.news_item_publication_text_view));
    public static ViewInteraction creationDate = onView(withId(R.id.news_item_creation_text_view));
    public static ViewInteraction author = onView(withId(R.id.news_item_author_text_view));
    public static ViewInteraction statusNews = onView(withId(R.id.news_item_published_text_view));

    //Меню каждой новости
    public static ViewInteraction deleteNews = onView(withId(R.id.delete_news_item_image_view));
    public static ViewInteraction editNews = onView(withId(R.id.edit_news_item_image_view));
    public static ViewInteraction viewDescriptions = onView(withId(R.id.view_news_item_image_view));
}
