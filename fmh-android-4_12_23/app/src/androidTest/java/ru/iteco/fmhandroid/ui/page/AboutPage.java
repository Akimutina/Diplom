package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {
    public static ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
    public static ViewInteraction versionTitleField = onView(withId(R.id.about_version_title_text_view));
    public static ViewInteraction versionNumberField = onView(withId(R.id.about_version_value_text_view));
    public static ViewInteraction policyText = onView(withId(R.id.about_privacy_policy_label_text_view));
    public static ViewInteraction termsOfUseText = onView(withId(R.id.about_terms_of_use_label_text_view));
    public static ViewInteraction infoCompany = onView(withId(R.id.about_company_info_label_text_view));
    public static ViewInteraction privacyPolicyValue = onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction termsOfUseValue = onView(withId(R.id.about_terms_of_use_value_text_view));
}
