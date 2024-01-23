package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.childAtPosition;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelPage {

    public static ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction titlePage = onView(withText("Панель управления"));
    public static ViewInteraction newsList = onView(withId(R.id.news_list_recycler_view));

    //Меню панели управления
    public static ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));

    //Блок каждой новости

    public static ViewInteraction newsConstraintLayout = onView(allOf(withId(R.id.news_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));

    public static ViewInteraction newsTitleText =
            onView(withIndex(withId(R.id.news_item_title_text_view), 0));
    public static ViewInteraction newsDescriptionText = onView(withIndex(withId(R.id.news_item_description_text_view), 0));
    public static ViewInteraction publicationDate = onView(withIndex(withId(R.id.news_item_publication_text_view), 0));
    public static ViewInteraction creationDate = onView(withId(R.id.news_item_creation_text_view));
    public static ViewInteraction author = onView(withId(R.id.news_item_author_text_view));
    public static ViewInteraction statusActive =
            onView(withIndex(withId(R.id.news_item_published_text_view), 0));
    public static ViewInteraction statusNotActive =
            onView(withIndex(withId(R.id.news_item_published_text_view), 0));

    //Меню каждой новости
    public static ViewInteraction deleteNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.delete_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(newsTitle))))))));
    }

    public static ViewInteraction editNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.edit_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(newsTitle))))))));
    }

}
