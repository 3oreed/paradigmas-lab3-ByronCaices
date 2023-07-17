package myfilesystem.models;

import myfilesystem.interfaces.IUser;

public class User implements IUser {
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


    @Override
    public String toString() {
        return userName;
    }
}
