package data;

import data.model.User;

public class UserGenerator {
    public static User validUser(){
        User validUser = new User("decorepanno", "DecorPann");
        return validUser;
    }

    public static String validUserLogin(){
        return validUser().getName();
    }

    public static String validUserPassword(){
        return validUser().getPassword();
    }
}
