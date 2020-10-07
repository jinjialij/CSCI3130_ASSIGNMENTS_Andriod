package ca.dal.cs.csci3130.a2;

import com.google.firebase.database.DatabaseReference;

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
