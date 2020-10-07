package ca.dal.cs.csci3130.a2;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserService {

    public static boolean registerNewUser(DatabaseReference db, String name, String email) {
        if(User.isValid(name,email)){
            User user = new User(name, email);
            db.child(user.getUsername()).setValue(user);

            return true;
        }

        return false;
    }
}
