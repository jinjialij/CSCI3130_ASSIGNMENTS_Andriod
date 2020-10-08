package ca.dal.cs.csci3130.a2;

import androidx.annotation.NonNull;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class registrationTest {
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
