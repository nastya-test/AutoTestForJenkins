package PageObject.Data;

public class user {

    private String name;
    private String password;

    public user(String name, String password) {
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

    public static user validUser(){
        user validUser = new user("decorepanno", "DecorPann");
        return validUser;
    }

    public static String validUserLogin(){
        return validUser().getName();
    }

    public static String validUserPassword(){
        return validUser().getPassword();
    }
}
