package myfilesystem.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystem {

    String systemName;
    Date systemDate;
    User logedUser;

    Path currentPath;
    List<Drive> drives;
    List<User> users;
    List<Path> paths;
    List<Item> trashcan;
    List<Item> content;


    //RF3 Constructor del System
    // Dom: Name
    // Rec: System
    /**
     * Crea una nueva instancia de FileSystem.
     *
     * @param systemName El nombre del sistema de archivos. Se convertirá a minúsculas.
     */
    public FileSystem(String systemName) {
        this.systemName = systemName.toLowerCase();
        this.systemDate = new Date();
        this.logedUser = null;
        this.currentPath = new Path();
        this.drives = new ArrayList<>();
        this.users = new ArrayList<>();
        this.paths = new ArrayList<>();
        this.trashcan = new ArrayList<>();
        this.content = new ArrayList<>();
    }


    public boolean existingUser(String username) {

        var namesUsers = users.stream().map(User::getUserName).collect(Collectors.toList());
        //String username = user.getUserName();
        if (namesUsers.contains(username)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existingLetter(String letter) {


        var letters = drives.stream()
                .map(Drive::getLetter)
                .collect(Collectors.toList());

        if (letters.contains(letter)) {
            return true;
        } else {
            return false;
        }
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
        if (!existingUser(newUserName)) {
            users.add(newUser);
            System.out.println("\n>> register: Usuario anadido con exito: " + newUserName );
        } else {
            System.out.println("\n>> register: El Usuario que intentas añadir \"" + newUserName + "\" ya existe :(");
        }
    }

    //RF6

    public void login(String userName){
        userName = userName.toLowerCase();

        if (existingUser(userName)){
            User registeredUser = new User(userName);
            this.logedUser = registeredUser;
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
    public void switchDrive(String letter){
        letter = letter.toLowerCase();
        if ((!logedUser.isUserNull()) && (existingLetter(letter))) {
            this.currentPath.ruta = letter + ":/";
            System.out.println("\n>> switchDrive: Se cambiado a la unidad "+letter.toUpperCase());
        }
        else{
            System.out.println("\n>> switchDrive: no se ha podido cambiar de unidad");
        }
    }

    public boolean existingPath(Path newPathObj){

        String newpath = newPathObj.pathToString();
        ArrayList<String> pathStrings = new ArrayList<>();
        for(Path path : paths ){
            pathStrings.add(path.pathToString());
        }

        if (pathStrings.contains(newpath)){
            return true;
        }
        return false;
    }
    //RF9
    public void mkdir(String folderName){
        //existingPath
        folderName = folderName.toLowerCase();
        //Path newPath = new Path(getCurrentPath().path+folderName+"/");
        Path newPath = new Path(getCurrentPath().appendFolder(folderName));
        //String newPath = getCurrentPath() + folderName + "/";

        if (!existingPath(newPath)) {

            Folder newFolder = new Folder(folderName);
            newFolder.setCreateDate(getSystemDate());
            newFolder.setModDate(getSystemDate());
            newFolder.setLocation(new Path(getCurrentPath().pathToString()+folderName+"/"));
            newFolder.setCreator(getLogedUser().getUserName());

            content.add(newFolder);
            paths.add(newPath);
            System.out.println("\n>> mkdir: directorio " + folderName + " creado con exito");
        }
        else{
            System.out.println("\n>> mkdir: el directorio que intentas anadir" +
                               "\n          ya existe en la ruta actual >" + folderName);
        }
    }

    public void cd(String pathname){

        //String pathnamecopy = pathname;
        //String dia = 3;
        //String nombreDelDia;

        switch (pathname) {
            case "..":
                currentPath.backToFolderPadre();
                System.out.println("\n>> cd: regresa a carpeta anterior" +
                                   "\n       "+currentPath.ruta+" >");
                break;
            case "/":
                currentPath.backToRoot();
                System.out.println("\n>> cd: regresa a raiz de la unidad" +
                                   "\n       "+currentPath.ruta+" >");
                break;

            default:
                if (existingPath(new Path(currentPath.appendFolder(pathname)))) {
                    currentPath.enterFolder(pathname);
                    System.out.println("\n>> cd: entra a directorio " + pathname +
                                       "\n       " + currentPath.ruta + " >");
                    break;
                }
                System.out.println("\n>> cd: La ruta a la que intentas acceder no existe");
                break;
        }
    }

    public void addFile(File newfile) {

        Path newFilePath = new Path(newfile.getLocation().pathToString());

        if (existingPath(newFilePath)) {
            System.out.println("test1 passed");
            // Si ya existe un archivo en la ruta actual con el mismo nombre
            // actualiza tipo (extension) y contenido de ESE archivo con el del nuevo File
            for (Item item : content) {

                System.out.println(item.getLocation().pathToString()+" == "+newFilePath.pathToString());

                if (item.getLocation().pathToString().equals(newFilePath.pathToString())) {
                    System.out.println("test2 passed");
                    item.setExtension(newfile.getExtension());
                    item.setText(newfile.getText());
                    System.out.println("\n>> addFile: el archivo que intentas anadir ya existe en la ruta actual" +
                                       "\n   por lo que se ha modificado su extension (tipo) y contenido (text)\n"+ item);
                }
            }
        }else{
            System.out.println("test3 passed");
            content.add(newfile);
            paths.add(newfile.getLocation());
            System.out.println("\n>> addFile: el archivo "+newfile.getItemName()+" ha sido anadido en la ruta actual");
        }
    }

    public Item searchFileByName(String filename){
        File myfile = new File();
        for (Item item : content){
            if (item.getItemName().equals(filename)){
                return item;
            }
        }
        return null;
    }



    public void del(String filepathern){

        //Si es filename entonces busco el File
        if (!filepathern.contains("*")){
            Item myfile = searchFileByName(filepathern);
        }

        //Obtengo extension del nombre
        String extension = "";
        int dotIndex = filepathern.lastIndexOf('.');
        if (dotIndex >= 0) {
            extension = filepathern.substring(dotIndex + 1);
        }

        if (filepathern.equals("*."+extension)){
            ArrayList<Item> newContent = new ArrayList<>();
            for (Item item : content) {
                if (!item.getExtension().equals(extension) && //Si no es .txt Y si contiene el current path
                        item.getLocation().pathToString().contains(currentPath.pathToString())) {
                    //entonces lo agregamos al nuevo content
                    newContent.add(item);
                }
            }
            content = newContent; //agrega lista con los .extension eliminados
        }

        else if (filepathern.equals("*.*") || filepathern.equals("*")){
            ArrayList<Item> newContent = new ArrayList<>();
            for (Item item : content) {
                if (!item.getExtension().equals(extension) && //Si no es .txt Y si contiene el current path
                        item.getLocation().pathToString().contains(currentPath.pathToString())) {
                    //entonces lo agregamos al nuevo content
                    newContent.add(item);
                }
            }

        }
    }




    @Override
    public String toString() {
        return "####\nFileSystem{" +
                "\n~systemName='" + systemName + '\'' +
                "\n~systemDate=" + systemDate +
                "\n~logedUser=" + logedUser +
                "\n~currentPath='" + currentPath + '\'' +
                "\n~drives=" + drives +
                "\n~users=" + users +
                "\n~paths=" + paths +
                "\n~trashcan=" + trashcan +
                "\n~content=" + content +
                '}';
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public User getLogedUser() {
        return logedUser;
    }

    public Path getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        currentPath = currentPath.toLowerCase();
        this.currentPath.ruta = currentPath;
    }


}

/*
for (Drive drive : drives) {
        letters.add(drive.getLetter());
        }

 */
