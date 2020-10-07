package ca.dal.cs.csci3130.a2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AccountRegistrationUnitTest {
    @Test
    public void createUser() {
        String username = "jiali";
        String email = "jl@dal.ca";
        User user = new User(username, email);

        assertEquals(username, user.getUsername());
        assertEquals(email, user.getEmail());
    }
}