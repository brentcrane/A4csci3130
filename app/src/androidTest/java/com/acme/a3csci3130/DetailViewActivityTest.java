package com.acme.a3csci3130;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DetailViewActivityTest {

    private MyApplicationData appData;

    /**
     * Get the reference to the DetailViewActivity class
     */
    @Rule
    public ActivityTestRule<DetailViewActivity> activityRule = new ActivityTestRule<>(DetailViewActivity.class);

    /**
     * Set up the intent and the firebase data
     */
    @Before
    public void init() {
        appData = (MyApplicationData) activityRule.getActivity().getApplication();
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("businesses");
        activityRule.launchActivity(new Intent());
    }

    /**
     * Test the Update Business button which will update the info for a business
     * @throws Exception
     */
    @Test
    public void updateBusinessTest() throws Exception {
        // Correct values to enter
        String testNumber = "135792468";
        String testName = "NewBusinessName";
        String testPrimaryBusiness = "Fisher";
        String testAddress = "NewAddressHere";
        String testProvince = "BC";

        onView(withId(R.id.number)).perform(typeText(testNumber));
        closeSoftKeyboard();
        onView(withId(R.id.name)).perform(typeText(testName));
        closeSoftKeyboard();
        onView(withId(R.id.primaryBusiness)).perform(typeText(testPrimaryBusiness));
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(typeText(testAddress));
        closeSoftKeyboard();
        onView(withId(R.id.province)).perform(typeText(testProvince));
        closeSoftKeyboard();

        onView(withId(R.id.updateButton));
    }

    /**
     * Test the Erase Business button, which will delete the current business from the database
     * @throws Exception
     */
    @Test
    public void deleteBusinessTest() throws Exception {

        onView(withId(R.id.eraseButton));
    }
}
