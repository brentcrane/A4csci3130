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
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CreateBusinessActivityTest {

    private MyApplicationData appData;

    /**
     * Get a reference to the CreateBusinessActivity class
     */
    @Rule
    public ActivityTestRule<CreateBusinessActivity> activityRule = new ActivityTestRule<>(CreateBusinessActivity.class);

    /**
     * Set up the intent and firebase info
     */
    @Before
    public void init() {
        appData = (MyApplicationData) activityRule.getActivity().getApplication();
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("businesses");
        activityRule.launchActivity(new Intent());
    }

    /**
     * Test the Create Business activity with some filler info
     * @throws Exception
     */
    @Test
    public void createBusiness() throws Exception {

        // Correct values to enter
        String testNumber = "112233445";
        String testName = "TestBusinessOne";
        String testPrimaryBusiness = "Fisher";
        String testAddress = "WallabeeWay";
        String testProvince = "NS";

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

        onView(withId(R.id.submitButton));
    }
}
