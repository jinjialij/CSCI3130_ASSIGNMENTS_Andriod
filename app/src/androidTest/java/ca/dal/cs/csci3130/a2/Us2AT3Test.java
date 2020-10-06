package ca.dal.cs.csci3130.a2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class Us2AT3Test {

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
}
