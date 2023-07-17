package myfilesystem.models;

import myfilesystem.interfaces.IFileSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystem implements IFileSystem {

    String systemName;
    Date systemDate;
    User logedUser;
    Path currentPath;
    List<Drive> drives;
    List<User> users;
    List<Path> paths;
    List<Item> trashcan;
    List<Item> content;

    public FileSystem() {
        this.systemName = "".toLowerCase();
        this.systemDate = new Date();
        this.logedUser = new User();
        this.currentPath = new Path();
        this.drives = new ArrayList<>();
        this.users = new ArrayList<>();
        this.paths = new ArrayList<>();
        this.trashcan = new ArrayList<>();
        this.content = new ArrayList<>();
    }

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
        this.logedUser = new User();
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

        if (existingUser(userName) && logedUser.isUserNull()){
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
            System.out.println("\n>> switchDrive: Se ha cambiado a la unidad "+letter.toUpperCase());
        }
        else{
            System.out.println("\n>> switchDrive: no se ha podido cambiar de unidad");
        }
    }


    public boolean existingPath(Path newPathObj){

        String newpath = newPathObj.pathToString();
        ArrayList<String> pathStrings = new ArrayList<>();
        for(Item item : content ){
            pathStrings.add(item.getLocation().pathToString());
        }

        if (pathStrings.contains(newpath)){
            return true;
        }
        return false;
    }
    public boolean existingPath(String newpath){

        //String newpath = newPathObj.pathToString();
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
            newFolder.setExtension("");

            //System.out.println(newFolder);
            content.add(newFolder);
            paths.add(newPath);
            System.out.println("\n>> mkdir: directorio " + folderName + " creado con exito" +
                               "\n          ->  "+newPath.pathToString());
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
                currentPath = new Path(currentPath.backToFolderPadre());
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

        Path newFilePath = new Path(currentPath.pathToString()+newfile.getItemName());
        newfile.setLocation(new Path(currentPath.pathToString()+newfile.getItemName()));
        //System.out.println("## LOCATION: "+ newfile.getLocation().pathToString());


        if (existingPath(newFilePath)) {
            //System.out.println("test1 passed");
            // Si ya existe un archivo en la ruta actual con el mismo nombre
            // actualiza tipo (extension) y contenido de ESE archivo con el del nuevo File
            for (Item item : content) {

                System.out.println(item.getLocation().pathToString()+" == "+newFilePath.pathToString());

                if (item.getLocation().pathToString().equals(newFilePath.pathToString())) {
                    //System.out.println("test2 passed");
                    item.setExtension(newfile.getExtension());
                    item.setText(newfile.getText());
                    System.out.println("\n>> addFile: el archivo que intentas anadir ya existe en la ruta actual" +
                                       "\n   por lo que se ha modificado su extension (tipo) y contenido (text)\n"+ item);
                }
            }
        }else{
            //newfile.setLocation(new Path(currentPath.pathToString()+newfile.getItemName()));
            //newfile.setModDate(new Date());

            //System.out.println("test3 passed");
            //System.out.println(currentPath);
            //System.out.println(newfile.getItemName());
            //System.out.println(newfile.getLocation().pathToString());
            content.add(newfile);
            paths.add(newfile.getLocation());
            System.out.println("\n>> addFile: el archivo "+newfile.getItemName()+" ha sido anadido en la ruta actual");
        }
    }


    public void del(String filepathern){
        filepathern.toLowerCase();

        int type = 4;
        //Determina si es folder 2, file 1 o filepathern 3
        if (filepathern.contains("*")) {
            type = 3;
        } else if (filepathern.contains(".") && !filepathern.contains("*")) {
            type = 1;
        }
        else{
            type = 2;
            filepathern=filepathern+"/"; //dir name
        }
        //System.out.println("77777");
        //System.out.println(filepathern);
        //System.out.println(type);

        String rutaFilePathern = currentPath.pathToString()+filepathern;
        ArrayList<Item> newContent = new ArrayList<>();

        if (!existingPath(rutaFilePathern) && type<3){
            type = 4; //no existe archivo
        }
        //System.out.println(type);


        switch (type){
            case 1:
                if (existingPath(rutaFilePathern)) {
                    for (Item item : content) {
                        //System.out.println(item.getLocation().pathToString() + " != " + rutaFilePathern);
                        if (!item.getLocation().pathToString().equals(rutaFilePathern)) {
                            //System.out.println("test44");
                            newContent.add(item);
                        } else {
                            trashcan.add(item);
                            //System.out.println("test4");
                        }
                    }
                    System.out.println("\n>> del: se ha eliminado el archivo " + filepathern);
                }
                content = newContent;
                break;
            case 2:
                if (existingPath(rutaFilePathern)) {
                    for (Item item : content) {
                        if (!item.getLocation().pathToString().contains(rutaFilePathern)) {
                            newContent.add(item);
                        } else {
                            trashcan.add(item);
                        }
                    }
                    System.out.println("\n>> del: se ha eliminado el directorio " + filepathern);
                }
                content = newContent;
                break;
            case 3:
                String extension = "";
                int dotIndex = filepathern.lastIndexOf('.');
                if (dotIndex >= 0) {
                    extension = filepathern.substring(dotIndex + 1);
                }

                if (filepathern.equals("*." + extension) && extension.length()>1) {
                    //ArrayList<Item> newContent = new ArrayList<>();
                    for (Item item : content) {
                        //si extension es igual y se encuentra en el current path
                        //Si no es .txt Y si contiene el current path
                        if (item.getExtension().equals(extension) && item.getLocation().backToFolderPadre().equals(currentPath.pathToString())) {
                            //entonces lo mandamos a papelera
                            //System.out.println("3433");
                            //System.out.println(paths);
                            trashcan.add(item);
                            //System.out.println(paths);
                        } else {
                            newContent.add(item);
                        }
                    }
                    System.out.println("\n>> del: se han eliminado todos los archivos ."+ extension +" de la ruta actual");
                    content = newContent; //agrega lista con los .extension eliminados
                }
                // ### 2 borrar todos los archivos de una ruta
                else if (filepathern.equals("*.*") || filepathern.equals("*")) {
                    //ArrayList<Item> newContent = new ArrayList<>();
                    for (Item item : content) {

                        //(si es File y se encuentra en el current path) me lo salto
                        //si es folder y se encuentra en el current path -- pa dentro
                        //si es file y no se encuentra en el current path -- pa dentro
                        if (item.isFile() && item.getLocation().backToFolderPadre().equals(currentPath.pathToString())) {
                            //lo mando a la papelera
                            trashcan.add(item);
                        } else {
                            newContent.add(item);
                        }
                    }
                    System.out.println("\n>> del: se han eliminado todos los archivos de la ruta actual");
                    content = newContent;
                }
                break;

            default:
                System.out.println("\n>> del: el item que intentas eliminar no existe en al ruta actual");
                break;

        }
    }





    @Override
    public String toString() {
        return "\n|----------------------------|\n" +
               "|       TU FileSystem        |\n" +
               "|----------------------------|\n" +
               "\n~ systemName  = '" + systemName + '\'' +
               "\n~ systemDate  = " + systemDate +
               "\n~ logedUser   = " + logedUser.getUserName() +
               "\n~ currentPath = '" + currentPath.pathToString() + '\'' +
               "\n~ drives      = " + drives +
               "\n~ users       = " + users +
               "\n~ paths       = " + paths +
               "\n~ trashcan    = " + trashcan +
               "\n~ content     = " + content;
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


    public void setSystemName(String systemName) {
        systemName.toLowerCase();
        this.systemName = systemName;
    }


}

