package ca.dal.cs.csci3130.a2;

public class User {
    private String username;
    private String email;

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static boolean isValid(String username, String email){
        if (username == null || email == null){
            return false;
        }

        if (username == "" || email == ""){
            return false;
        }

        if(!ValidationHelper.isValidName(username) || !ValidationHelper.isValidEmail(email)){
            return false;
        }
        return true;
    }
}
