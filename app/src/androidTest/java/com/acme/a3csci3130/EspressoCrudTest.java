package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class EspressoCrudTest {

    private DatabaseReference dbRef;


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);
    private MainActivity mainActivity;

    @Before
    public void setup() throws Exception {
        mainActivity = mActivityRule.getActivity();
        dbRef = FirebaseDatabase.getInstance().getReference("businesses");
        dbRef.removeValue();
    }

    @Test
    public void onBusinessCreation() {
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name)).perform(typeText("Test Inc"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("946125363"), closeSoftKeyboard());
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("184 Test Ave"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("AB"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).check(matches(withText("Test Inc")));
        onView(withId(R.id.number)).check(matches(withText("946125363")));
        onView(withId(R.id.primaryBusiness)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("184 Test Ave")));
        onView(withId(R.id.province)).check(matches(withText("AB")));
    }

    @Test
    public void onBusinessUpdate() {
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name)).perform(typeText("Test Inc"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("946125363"), closeSoftKeyboard());
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("184 Test Ave"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("AB"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        onView(withId(R.id.name)).perform(replaceText("Testing INC"), closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).check(matches(withText("Testing INC")));
    }

    @Test
    public void onBusinessRead() {
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name)).perform(typeText("AnotherBusiness"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("946125363"), closeSoftKeyboard());
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("184 Test Ave"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        onView(withId(R.id.name)).check(matches(withText("AnotherBusiness")));
    }

    @Test
    public void onBusinessDelete() {
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name)).perform(typeText("Test Inc"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("946125363"), closeSoftKeyboard());
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("AB"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        onView(withId(R.id.deleteButton)).perform(click());

        onView(withId(R.id.listView)).check(matches(not(isDisplayed())));
    }
}
