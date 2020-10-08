package ca.dal.cs.csci3130.a2;

import androidx.annotation.NonNull;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class loginTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    static DatabaseReference db;
    static Map<String, User> userMap =  new HashMap<>();

    @BeforeClass
    public static void setup(){
        db  = FirebaseDatabase.getInstance().getReference();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();
                while(!value.isEmpty()){
                    Iterator it = value.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        Map<String, String> usercontent = (Map<String, String>)pair.getValue();
                        User user = new User(usercontent.get("username"),usercontent.get("email"));
                        userMap.put(usercontent.get("username"), user);
                        it.remove();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Test
    public void testLogin_withAccount(){
        String username = "jiali";
        String email = "jl123@d.ca";
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText(username), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText(email), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonRegister))
                .perform(click());
        onView(withId(R.id.buttonPrevious))
                .perform(click());
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText(username), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText(email), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonLogin))
                .perform(click());
        assertFalse(userMap.isEmpty());
        assertTrue(userMap.containsKey(username));
        assertEquals(userMap.get(username).getEmail(), email);
    }

    @Test
    public void testLogin_withoutAccount() {
        String username = "abcd";
        String email = "abcd@d.ca";
        onView(withId(R.id.editTextName))
                .perform(click())
                .perform(typeText(username), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editTextEmail))
                .perform(click())
                .perform(typeText(email), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonLogin))
                .perform(click());
        assertFalse(userMap.containsKey(username));
    }

    
//
//    @Rule
//    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);
//    static DatabaseReference db;
//    static ArrayList<User> users =  new ArrayList<User>();
//
//    @BeforeClass
//    public static void setup(){
//        db  = FirebaseDatabase.getInstance().getReference();
//
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();
//                while(!value.isEmpty()){
//                    Iterator it = value.entrySet().iterator();
//                    while (it.hasNext()) {
//                        Map.Entry pair = (Map.Entry)it.next();
//                        Map<String, String> usercontent = (Map<String, String>)pair.getValue();
//                        User user = new User(usercontent.get("username"),usercontent.get("email"));
//                        users.add(user);
//                        it.remove();
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
//
//    @Test
//    public void testLogin(){
//        onView(withId(R.id.editTextName))
//                .perform(click())
//                .perform(typeText("jiali"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.editTextEmail))
//                .perform(click())
//                .perform(typeText("jl123@d.ca"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.buttonRegister))
//                .perform(click());
//        onView(withId(R.id.buttonPrevious))
//                .perform(click());
//        onView(withId(R.id.editTextName))
//                .perform(click())
//                .perform(typeText("jiali"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.editTextEmail))
//                .perform(click())
//                .perform(typeText("jl123@d.ca"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.buttonLogin))
//                .perform(click());
//        onView(withId(R.id.welcomeTextView))
//                .check(matches(withText("Welcome back, jiali!")));
//    }
}
