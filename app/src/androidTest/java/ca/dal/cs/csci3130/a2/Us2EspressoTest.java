package ca.dal.cs.csci3130.a2;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;

public class Us2EspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testEditTextName(){
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText("jiali"));
        onView(withId(R.id.editTextName))
                .check(matches(withText("jiali")));
    }

    @Test
    public void testEditTextEmail(){
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText("jiali@123"));
        onView(withId(R.id.editTextEmail))
                .check(matches(withText("jiali@123")));
    }

    @Test
    public void testRegisterButton(){
        onView(withId(R.id.buttonRegister))
                .check(matches(withText("Registration")));
    }

    @Test
    public void testErrorMessageForWrongUsername_non_alphanumeric(){
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText("#^^&"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonRegister))
                .perform(click())
                .check(matches(isEnabled()));;
        onView(withId(R.id.errorMessageNameView))
                .check(matches(withText("Username is non-alphanumeric")));
    }

    @Test
    public void testErrorMessageForWrongUsername_empty(){
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonRegister))
                .perform(click());
        onView(withId(R.id.errorMessageNameView))
                .check(matches(withText("Username is empty")));
    }

    @Test
    public void testInvalidEmail_wrong_format(){
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText("dadasgmail"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonRegister))
                .perform(click())
                .check(matches(isEnabled()));;
        onView(withId(R.id.errorMessageEmailView))
                .check(matches(withText("Invalid Email address")));
    }

    @Test
    public void testInvalidEmail__empty(){
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonRegister))
                .perform(click());
        onView(withId(R.id.errorMessageEmailView))
                .check(matches(withText("Email is empty")));
    }

    @Test
    public void test__welcome_screen_for_new_account(){
        Random random = new Random();
        int num = random.nextInt(100);
        String username = "jiali" + num;
        String email = "jl" + num + "@d.ca";
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText(username), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText(email), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonRegister))
                .perform(click());
        onView(withId(R.id.welcomeTextView))
                .check(matches(withText("Welcome " + username + "!\nA welcome email was sent to " + email)));
    }
}
