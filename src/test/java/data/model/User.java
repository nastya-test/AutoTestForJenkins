package data.model;

public class User {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.name = password;
    }

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
