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

        String newpath = newPathObj.ruta;
        ArrayList<String> pathStrings = new ArrayList<>();
        for(Path path : paths ){
            pathStrings.add(path.ruta);
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
            newFolder.setLocation(getCurrentPath());
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

        String pathnamecopy = pathname;
        //String dia = 3;
        String nombreDelDia;

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

        //metodo que determina una entrada del cd y asigna numero para
        //realizar operaciones

        //System.out.println(nombreDelDia); // Esto imprimirá "Miércoles"

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
