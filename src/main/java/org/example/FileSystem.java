package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystem {

    String systemName;
    Date systemDate;
    User logedUser;

    String currentPath;
    List<Drive> drives;
    List<User> users;


    //RF3 Constructor del System
    // Dom: Name
    // Rec: System
    public FileSystem(String systemName) {
        this.systemName = systemName.toLowerCase();
        this.systemDate = new Date();
        this.logedUser = new User();
        this.currentPath = "";
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
            System.out.println("\n>> addDrive: Drive añadido con éxito: " + letter.toUpperCase());
        } else {
            System.out.println("\n>> addDrive: La letra que intentas añadir \"" + letter.toUpperCase() + "\" ya existe :(");
        }

    }

    //RF5
    public void register(String newUserName) {
        newUserName = newUserName.toLowerCase();
        User newUser = new User(newUserName);
        if (!existingUser(newUser)) {
            users.add(newUser);
            System.out.println("\n>> register: Usuario añadido con éxito: " + newUserName );
        } else {
            System.out.println("\n>> register: El Usuario que intentas añadir \"" + newUserName + "\" ya existe :(");
        }
    }

    //RF6

    public void login(String userName){
        userName = userName.toLowerCase();
        User regUser = new User(userName);

        if (existingUser(regUser)){
            this.logedUser = regUser;
            System.out.println("\n>> login: Usuario \"" + userName + "\" logeado con exito");
        }
        else{
            System.out.println("\n>> login: El usuario \"" + userName + "\" no existe o ya hay una sesion iniciada");
        }
    }

    //RF7
    public void logout(){

        this.logedUser = new User();
        System.out.println("\n>> logout: Se han cerrado todas las sesiones");
    }

    //RF8

    @Override
    public String toString() {
        return "\n###\nFileSystem{" +
                "systemName='" + systemName + '\'' +
                ",\n systemDate=" + systemDate +
                ",\n logedUser=" + logedUser +
                ",\n currentPath=" + currentPath +
                ",\n drives=" + drives +
                ",\n users=" + users +
                '}';
    }
}

/*
for (Drive drive : drives) {
        letters.add(drive.getLetter());
        }

 */
