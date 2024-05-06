package com.example.authorization;

public class User {
    private String Name;
    private String Login;
    private String Password;

    public User(String name, String login, String password) {
        Name = name;
        Login = login;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
