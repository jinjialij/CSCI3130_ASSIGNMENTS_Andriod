package ca.dal.cs.csci3130.a2;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

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

    public static void readData(DatabaseReference db, final Map<String, User> userMap) {
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

    public static boolean accountExists(String name, String email, Map<String, User> userMap) {
        if (!userMap.isEmpty() && userMap.containsKey(name)){
            User user = userMap.get(name);
            if(user.getEmail().equals(user.getEmail())){
                return true;
            }
        }

        return false;
    }
}
