package com.danluong.yaraa;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.danluong.yaraa.views.IntroActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by dluong on 8/13/2015.
 */
@RunWith(AndroidJUnit4.class)
public class IntroActivityTest {
    private static final String KEY_SP_PACKAGE = "prefs";

    @Rule
    public ActivityTestRule<IntroActivity> mActivityRule = new ActivityTestRule<>(IntroActivity.class);

    @Before
    public void setUp() throws Exception {
        // Clear everything in the SharedPreferences
        SharedPreferences sharedPreferences = InstrumentationRegistry.getTargetContext()
                .getSharedPreferences(KEY_SP_PACKAGE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    @After
    public void tearDown() throws Exception {
        // Clear everything in the SharedPreferences
        SharedPreferences sharedPreferences = InstrumentationRegistry.getTargetContext().
                getSharedPreferences(KEY_SP_PACKAGE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    @Test
    public void isFirstRunFlagSetFalseAfterLaunch() {
        // check that the button is there
        onView(withId(R.id.skip)).check(matches(isDisplayed()));

        SharedPreferences sharedPreferences = InstrumentationRegistry.getTargetContext().
                getSharedPreferences(KEY_SP_PACKAGE, Context.MODE_PRIVATE);
        assertTrue(sharedPreferences.getBoolean("firstRun", true));

        onView(withId(R.id.skip)).perform(click());
        assertFalse(sharedPreferences.getBoolean("firstRun", true));
    }
}
