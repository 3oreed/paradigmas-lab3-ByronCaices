package org.example;

public class User {
    String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public User() {
        this.userName = "";
    }

    public boolean isUserNull() {
        if (userName == "") {
            return true;
        } else {
            return false;
        }
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName.toLowerCase();
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
