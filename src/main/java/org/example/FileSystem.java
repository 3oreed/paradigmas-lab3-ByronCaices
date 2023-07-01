package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FileSystem {

    String systemName;
    Date systemDate;
    User logedUser;
    List<Drive> drives;
    List<User> users;


    //RF3 Constructor del System
    // Dom: Name
    // Rec: System
    public FileSystem(String systemName) {
        this.systemName = systemName.toLowerCase();
        this.systemDate = new Date();
        this.drives = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public boolean existingDrive(Drive newdrive) {

        String letter = newdrive.getLetter();

        var letters = drives.stream()
                .map(Drive::getLetter)
                .collect(Collectors.toList());

        if (letters.contains(letter)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existingUser(User user) {

        var namesUsers = users.stream().map(User::getUserName).collect(Collectors.toList());
        String username = user.getUserName();
        if (namesUsers.contains(username)) {
            return true;
        } else {
            return false;
        }
    }

    //RF4
    public void addDrive(String letter, String name, int cap) {

        letter = letter.toLowerCase();
        var newdrive = new Drive(letter, name, cap);


        //Verifica que no exista un drive con la letra
        if (!existingDrive(newdrive)) {
            drives.add(newdrive);
        } else {
            System.out.println("La letra que intentas añadir \"" + letter.toUpperCase() + "\" ya existe :(");
        }

    }

    //RF5
    public void register(String newUserName) {
        newUserName = newUserName.toLowerCase();
        User newUser = new User(newUserName);
        if (!existingUser(newUser)) {
            users.add(newUser);
        } else {
            System.out.println("El Usuario que intentas añadir \"" + newUserName + "\" ya existe :(");
        }
    }

    @Override
    public String toString() {
        return "FileSystem{" +
                "systemName='" + systemName + '\'' +
                ", systemDate=" + systemDate +
                ", drives=" + drives +
                ", users=" + users +
                '}';
    }
}
/*
for (Drive drive : drives) {
        letters.add(drive.getLetter());
        }

 */
