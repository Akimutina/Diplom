package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesPage {
    public static ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction title = onView(withId(R.id.our_mission_title_text_view));
    public static ViewInteraction ourMissionList = onView(withId(R.id.our_mission_item_list_recycler_view));
    public static ViewInteraction missionConstraintLayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
}
