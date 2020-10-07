package ca.dal.cs.csci3130.a2;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;

public class registrationFirebaseTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testRegister(){
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText("jiali"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText("jl123@d.ca"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonRegister))
                .perform(click());
        onView(withId(R.id.successMessageTextView))
                .check(matches(withText("Successful registration!")));
    }

    @Test
    public void testLogin(){
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText("jiali"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText("jl123@d.ca"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonLogin))
                .perform(click());
        onView(withId(R.id.welcomeTextView))
                .check(matches(withText("Welcome back, jiali!")));
    }

}
