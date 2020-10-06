package ca.dal.cs.csci3130.a2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class EspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testNameAndEmailAndRegistrationButton(){
        onView(withId(R.id.editText_name))
                .perform(click())
                .perform(typeText("jiali"));
        onView(withId(R.id.editText_email))
                .perform(click())
                .perform(typeText("jiali@123"));
        onView(withId(R.id.editText_name))
                .check(matches(withText("jiali")));
        onView(withId(R.id.editText_email))
                .check(matches(withText("jiali@123")));
        onView(withId(R.id.button_register))
                .check(matches(withText("Registration")));
    }
}
