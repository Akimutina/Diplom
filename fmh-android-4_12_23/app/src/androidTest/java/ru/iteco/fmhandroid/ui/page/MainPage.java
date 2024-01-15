package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public static ViewInteraction mainLogo = onView(withId(R.id.trademark_image_view));

    // Выход из приложения
    public static ViewInteraction profileButton = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction logOutButton = onView(withText("Выйти"));

    // Бургерное Меню
    public static ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction mainOfMenu = onView(withText("Главная"));
    public static ViewInteraction newsOfMenu = onView(withText("Новости"));
    public static ViewInteraction aboutOfMenu = onView(withText("О приложении"));

    // Переход к блоку цитат о хосписе
    public static ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));

    // Блок новостей
    public static ViewInteraction titleOfNewsContainer = onView(withText("Новости"));
    public static ViewInteraction newsContainer = onView(withId(R.id.container_list_news_include_on_fragment_main));
    public static ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));

    //public static ViewInteraction newsContainerLayout = onView(withId(R.id.news_item_material_card_view));

}
