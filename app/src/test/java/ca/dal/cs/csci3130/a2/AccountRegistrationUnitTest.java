package ca.dal.cs.csci3130.a2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AccountRegistrationUnitTest {
    @Test
    public void isSavedAccount() {
        String username;
        String email;
        User newUser = new User(username, email);

        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.child("users").child(username).setValue(newUser);
        Map<String, String> user = readDb(db);
        assertTrue(user.containsKey(username));
        assertEquals(user.get(username), email);
    }
}