package se.oscarb.flowlist;

import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.parse.ParseCloud;
import com.parse.ParseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    private String phoneNumber;

    @Before
    public void setupPhoneNumber() {
        Resources resources = InstrumentationRegistry.getContext().getResources();
        phoneNumber = resources.getString(se.oscarb.flowlist.dev.test.R.string.test_phone_number);
    }


    @Test
    public void deleteUserAndLoginWithPhoneNumber() {

        try {
            ParseCloud.callFunction("deleteTestUser", new HashMap<String, Object>());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        loginWithPhoneNumber();
    }

    @Test
    public void loginWithPhoneNumber() {
        onView(withId(R.id.start_phone_login)).perform(click());

        onView(withId(R.id.com_accountkit_phone_number))
                .perform(replaceText(phoneNumber), closeSoftKeyboard());

        onView(withId(R.id.com_accountkit_next_button)).perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.com_accountkit_next_button)).perform(click());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(allOf(withText("Hello World!"), isDisplayed())).check(matches(isDisplayed()));
    }
}
