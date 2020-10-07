package ca.dal.cs.csci3130.a2;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

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

//    @Test
//    public void testErrorMessageForWrongUsername(){
//        onView(withId(R.id.editTextName))
//                .perform(click())
//                .perform(typeText("12345"));
//        onView(withId(R.id.buttonRegister))
//                .perform(click());
//        onView(withText("Empty or non-alphanumeric username"))
//                .inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
//    }
}
