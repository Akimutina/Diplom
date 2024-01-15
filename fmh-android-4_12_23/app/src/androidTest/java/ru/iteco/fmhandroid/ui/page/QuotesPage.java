package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesPage {
    public static ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction title = onView(withId(R.id.our_mission_title_text_view));
    public static ViewInteraction ourMissionList = onView(withId(R.id.our_mission_item_list_recycler_view));
    public static ViewInteraction quotesContainerLayout = onView(withId(R.id.our_mission_item_material_card_view));
    public static ViewInteraction viewDescriptions = onView(withId(R.id.our_mission_item_material_card_view));
}
