package codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IFileSystem_20915795_CaicesLima;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystem_20915795_CaicesLima implements IFileSystem_20915795_CaicesLima {

    private String systemName;
    private Date systemDate;
    private  User_20915795_CaicesLima logedUser;
    private Path_20915795_CaicesLima currentPath;
    private List<Drive_20915795_CaicesLima> drives;
    private List<User_20915795_CaicesLima> users;
    private List<Path_20915795_CaicesLima> paths;
    private List<Item_20915795_CaicesLima> trashcan;
    private List<Item_20915795_CaicesLima> content;

    //################################ RF3: CONSTRUCTOR ######################################
    /**
     * Descripción: Constructor del FileSystem
     * @param systemName: String.
     * @author Byron Caices
     *
     */

    public FileSystem_20915795_CaicesLima(String systemName) {
        this.systemName = systemName.toLowerCase();
        this.systemDate = new Date();
        this.logedUser = new User_20915795_CaicesLima();
        this.currentPath = new Path_20915795_CaicesLima();
        this.drives = new ArrayList<>();
        this.users = new ArrayList<>();
        this.paths = new ArrayList<>();
        this.trashcan = new ArrayList<>();
        this.content = new ArrayList<>();
    }


    //################################ RF4: ADDDRIVE ######################################
    /**
     * Descripción: Método que permite añadir una unidad a un sistema. La letra de la unidad debe ser única.
     * @param letter: String letra de la unidad.
     * @param name: String nombre de la unidad.
     * @param cap: Int capacidad de la unidad.
     * @author Byron Caices
     *
     */
    //RF4
    @Override
    public void addDrive(String letter, String name, int cap) {

        letter = letter.toLowerCase();
        var newdrive = new Drive_20915795_CaicesLima(letter, name, cap);


        //Verifica que no exista un drive con la letra
        if (!existingDrive(newdrive)) {
            drives.add(newdrive);
            System.out.println("\n>> addDrive: Drive añadido con éxito: " + letter.toUpperCase());
        } else {
            System.out.println("\n>> addDrive: La letra que intentas añadir \"" + letter.toUpperCase() + "\" ya existe :(");
        }

    }

    //################################ RF5: REGISTER ######################################
    /**
     * Descripción: Método que permite registrar un nuevo usuario al sistema. El nombre de usuario es único y no puede ser duplicado.
     * @param newUserName: String nombre del usuario a registrar.
     * @author Byron Caices
     *
     */
    //RF5
    @Override
    public void register(String newUserName) {
        newUserName = newUserName.toLowerCase();
        User_20915795_CaicesLima newUser = new User_20915795_CaicesLima(newUserName);
        if (!existingUser(newUserName)) {
            users.add(newUser);
            System.out.println("\n>> register: Usuario anadido con exito: " + newUserName );
        } else {
            System.out.println("\n>> register: El Usuario que intentas añadir \"" + newUserName + "\" ya existe :(");
        }
    }


    //################################ RF6: LOGIN ######################################
    /**
     * Descripción: Método que permite iniciar sesión con un usuario del sistema, solo si éste existe.
     * @param userName: String nombre del usuario que iniciará sesión.
     * @author Byron Caices
     *
     */
    //RF6
    @Override
    public void login(String userName){
        userName = userName.toLowerCase();

        if (existingUser(userName) && logedUser.isUserNull()){
            User_20915795_CaicesLima registeredUser = new User_20915795_CaicesLima(userName);
            this.logedUser = registeredUser;
            System.out.println("\n>> login: Usuario \"" + userName + "\" logeado con exito");
        }
        else{
            System.out.println("\n>> login: El usuario \"" + userName + "\" no existe o ya hay una sesion iniciada");
        }
    }

    //################################ RF7: LOGOUT ######################################
    /**
     * Descripción: Método que permite cerrar la sesión de un usuario en el sistema.
     * @author Byron Caices
     *
     */
    //RF7
    @Override
    public void logout(){

        this.logedUser = new User_20915795_CaicesLima();
        System.out.println("\n>> logout: Se han cerrado todas las sesiones");
    }


    //################################ RF8: SWITCHDRIVE ######################################
    /**
     * Descripción: Permite fijar la unidad en la que el usuario realizará acciones.
     * @param letter: String letra de la unidad que fijará.
     * @author Byron Caices
     *
     */
    //RF8
    @Override
    public void switchDrive(String letter){
        letter = letter.toLowerCase();
        if ((!logedUser.isUserNull()) && (existingLetter(letter))) {
            //this.currentPath.ruta = letter + ":/";
            this.currentPath = new Path_20915795_CaicesLima(letter + ":/");
            System.out.println("\n>> switchDrive: Se ha cambiado a la unidad "+letter.toUpperCase());
        }
        else{
            System.out.println("\n>> switchDrive: no se ha podido cambiar de unidad");
        }
    }

    //################################ RF9: MKDIR ######################################
    /**
     * Descripción: Crea directorio en la ruta actual
     * @param folderName: String nombre del directorio a crear.
     * @author Byron Caices
     *
     */
    //RF9
    @Override
    public void mkdir(String folderName){
        //existingPath
        folderName = folderName.toLowerCase();
        //Path newPath = new Path(getCurrentPath().path+folderName+"/");
        Path_20915795_CaicesLima newPath = new Path_20915795_CaicesLima(getCurrentPath().appendFolder(folderName));
        //String newPath = getCurrentPath() + folderName + "/";

        if (!existingPath(newPath)) {

            Folder_20915795_CaicesLima newFolder = new Folder_20915795_CaicesLima(folderName);
            newFolder.setCreateDate(getSystemDate());
            newFolder.setModDate(getSystemDate());
            newFolder.setLocation(new Path_20915795_CaicesLima(getCurrentPath().pathToString()+folderName+"/"));
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


    //################################### RF10: CD #######################################
    /**
     * Descripción: Método que permite cambiar la ruta (path) donde se realizarán las próximas operaciones.
     * @param pathname: String: Puede recibir comodines como ".." o "/" o bien nombre del/los folder a acceder
     * @author Byron Caices
     *
     */
    //RF10
    @Override
    public void cd(String pathname){

        //String pathnamecopy = pathname;
        //String dia = 3;
        //String nombreDelDia;

        switch (pathname) {
            case "..":
                currentPath = new Path_20915795_CaicesLima(currentPath.backToFolderPadre());
                System.out.println("\n>> cd: regresa a carpeta anterior" +
                        "\n       "+currentPath.getRuta()+" >");
                break;
            case "/":
                currentPath.backToRoot();
                System.out.println("\n>> cd: regresa a raiz de la unidad" +
                        "\n       "+currentPath.getRuta()+" >");
                break;

            default:
                if (existingPath(new Path_20915795_CaicesLima(currentPath.appendFolder(pathname)))) {
                    currentPath.enterFolder(pathname);
                    System.out.println("\n>> cd: entra a directorio " + pathname +
                            "\n       " + currentPath.getRuta() + " >");
                    break;
                }
                System.out.println("\n>> cd: La ruta a la que intentas acceder no existe");
                break;
        }
    }


    //################################ RF11: ADDFILE ######################################
    /**
     * Descripción: Método que permite añadir un archivo en la ruta actual.
     * @param newfile: File. Archivo creado por el usuario.
     * @author Byron Caices
     *
     */
    //RF11
    @Override
    public void addFile(File_20915795_CaicesLima newfile) {

        Path_20915795_CaicesLima newFilePath = new Path_20915795_CaicesLima(currentPath.pathToString()+newfile.getItemName());
        newfile.setLocation(new Path_20915795_CaicesLima(currentPath.pathToString()+newfile.getItemName()));

        //-------------------------------------------
        String extension = "";

        int dotIndex = newfile.getItemName().lastIndexOf('.');

        if (dotIndex >= 0) {
            extension = newfile.getItemName().substring(dotIndex + 1);
        }

        String addfileoutput = "\n>> addFile: el archivo "+newfile.getItemName()+" ha sido anadido en la ruta actual";


        if ("docx,doc,pdf".contains(extension)){
            addfileoutput = "\n>> addFile: Se agrego el DOCUMENTO "+newfile.getItemName()+ " en la ruta actual <-- " + new Date();
        } else if ("java,js,py,pl,rkt".contains(extension)) {
            addfileoutput = "\n>> addFile: Se agrego el CODIGO "+newfile.getItemName()+ " en la ruta actual <-- " + new Date();
        }else {
            addfileoutput = "\n>> addFile: Se agrego el ARCHIVO DE TEXTO "+newfile.getItemName()+ " en la ruta actual <-- " + new Date();
        }
        //---------------------------------------


        if (existingPath(newFilePath)) {
            //System.out.println("test1 passed");
            // Si ya existe un archivo en la ruta actual con el mismo nombre
            // actualiza tipo (extension) y contenido de ESE archivo con el del nuevo File
            for (Item_20915795_CaicesLima item : content) {

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
            System.out.println(addfileoutput);
        }
    }
    //################################### RF12: DEL ########################################
    /**
     * Descripción: Metodo para eliminar uno o varios archivos. Tambien puede eliminar directorios y su contenido.
     * @param filepathern: Filename o Filepathern (*.ext || *.* || *) .
     * @author Byron Caices
     *
     */
    //RF12
    @Override
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
        ArrayList<Item_20915795_CaicesLima> newContent = new ArrayList<>();

        if (!existingPath(rutaFilePathern) && type<3){
            type = 4; //no existe archivo
        }
        //System.out.println(type);


        switch (type){
            case 1:
                if (existingPath(rutaFilePathern)) {
                    for (Item_20915795_CaicesLima item : content) {
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
                    for (Item_20915795_CaicesLima item : content) {
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
                    for (Item_20915795_CaicesLima item : content) {
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
                    for (Item_20915795_CaicesLima item : content) {

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
    //################################### RF13: COPY ########################################
    /**
     * Descripción: Metodo para copiar uno o varios archivos. Tambien puede eliminar directorios y su contenido.
     * @param filepathern: Filename o Filepathern (*.ext || *.* || *) .
     * @author Byron Caices
     *
     */
    //RF13
    //@Override
    public void copy(String filepathern,String targetPath){
        filepathern.toLowerCase();
        targetPath.toLowerCase();
        boolean folderflag = true;

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


        String rutaFilePathern = currentPath.pathToString()+filepathern;
        //ArrayList<Item_20915795_CaicesLima> newContent = new ArrayList<>();
        ArrayList<Item_20915795_CaicesLima> copiedContent = new ArrayList<>();

        if (!existingPath(rutaFilePathern) && type<3){
            type = 4; //no existe archivo
        }
        //System.out.println(type);


        switch (type){
            case 1: //copia UN File
                if (existingPath(rutaFilePathern)) {

                    for (Item_20915795_CaicesLima item : content) {

                        if (!item.getLocation().pathToString().equals(rutaFilePathern)) {

                            //newContent.add(item);
                        } else {
                            //en vez de eliminarlo, lo agregare a la lista que quiero
                            Item_20915795_CaicesLima newItem = item.itemClone();
                            Path_20915795_CaicesLima newRuta = new Path_20915795_CaicesLima(targetPath);
                            newItem.setLocation(newRuta);
                            //copiedContent.add(newItem);
                            content.add(newItem);
                            paths.add(newRuta);

                        }
                    }
                    System.out.println("\n>> del: se ha eliminado el archivo " + filepathern);
                }
                //content = newContent;
                break;
            case 2: //copia Folder

                if (existingPath(rutaFilePathern)) {
                    for (Item_20915795_CaicesLima item : content) {



                        if (!item.getLocation().pathToString().contains(rutaFilePathern)) {
                            //newContent.add(item);
                        } else {
                            if (folderflag) {
                                targetPath = targetPath+item.getItemName();
                            }

                            folderflag = false;
                            Item_20915795_CaicesLima newItem = item.itemClone();

                            Path_20915795_CaicesLima newRuta = new Path_20915795_CaicesLima(targetPath + item.getItemName());

                            //newRuta = new Path_20915795_CaicesLima(targetPath + item.getItemName());

                            newItem.setLocation(newRuta);
                            //copiedContent.add(newItem);
                            content.add(newItem);
                            paths.add(newRuta);
                        }
                    }
                    System.out.println("\n>> del: se ha eliminado el directorio " + filepathern);
                }
                //content = newContent;
                break;
            case 3:
                String extension = "";
                int dotIndex = filepathern.lastIndexOf('.');
                if (dotIndex >= 0) {
                    extension = filepathern.substring(dotIndex + 1);
                }

                if (filepathern.equals("*." + extension) && extension.length()>1) {

                    for (Item_20915795_CaicesLima item : content) {
                        //si extension es igual y se encuentra en el current path
                        //Si no es .txt Y si contiene el current path
                        if (item.getExtension().equals(extension) && item.getLocation().backToFolderPadre().equals(currentPath.pathToString())) {
                            //entonces lo mandamos a papelera

                            Item_20915795_CaicesLima newItem = item.itemClone();
                            copiedContent.add(newItem);

                        } else {
                            //newContent.add(item);
                        }
                    }
                    System.out.println("\n>> del: se han eliminado todos los archivos ."+ extension +" de la ruta actual");
                    //content = newContent; //agrega lista con los .extension eliminados
                }
                // ### 2 borrar todos los archivos de una ruta
                else if (filepathern.equals("*.*") || filepathern.equals("*")) {
                    //ArrayList<Item> newContent = new ArrayList<>();
                    for (Item_20915795_CaicesLima item : content) {

                        //(si es File y se encuentra en el current path) me lo salto
                        //si es folder y se encuentra en el current path -- pa dentro
                        //si es file y no se encuentra en el current path -- pa dentro
                        if (item.isFile() && item.getLocation().backToFolderPadre().equals(currentPath.pathToString())) {
                            //lo mando a la papelera
                            Item_20915795_CaicesLima newItem = item.itemClone();
                            copiedContent.add(newItem);
                        } else {
                            //newContent.add(item);
                        }
                    }
                    System.out.println("\n>> del: se han eliminado todos los archivos de la ruta actual");
                    //content = newContent;
                }
                break;

            default:
                System.out.println("\n>> del: el item que intentas eliminar no existe en al ruta actual");
                break;

        }

    }


    //################################### VERIFICADORES DE EXISTENCIA ########################################
    /**
     * Descripción: Verificador de existencia
     * @param username: String.
     * @return True si existe el user en el FileSystem o no
     * @author Byron Caices
     *
     */
    @Override
    public boolean existingUser(String username) {

        var namesUsers = users.stream().map(User_20915795_CaicesLima::getUserName).collect(Collectors.toList());
        //String username = user.getUserName();
        if (namesUsers.contains(username)) {
            return true;
        } else {
            return false;
        }
    }
    //__________________________________________________________________________________________________________
    /**
     * Descripción: Verificador de existencia
     * @param letter: String.
     * @return True si existe la letra de unidad en el FileSystem o no
     * @author Byron Caices
     *
     */
    @Override
    public boolean existingLetter(String letter) {


        var letters = drives.stream()
                .map(Drive_20915795_CaicesLima::getLetter)
                .collect(Collectors.toList());

        if (letters.contains(letter)) {
            return true;
        } else {
            return false;
        }
    }
    //__________________________________________________________________________________________________________

    /**
     * Descripción: Verificador de existencia
     * @param newdrive: Drive.
     * @return True si existe la unidad en el FileSystem o no
     * @author Byron Caices
     *
     */
    @Override
    public boolean existingDrive(Drive_20915795_CaicesLima newdrive) {

        String letter = newdrive.getLetter();

        var letters = drives.stream()
                .map(Drive_20915795_CaicesLima::getLetter)
                .collect(Collectors.toList());

        if (letters.contains(letter)) {
            return true;
        } else {
            return false;
        }
    }
    //__________________________________________________________________________________________________________
    /**
     * Descripción: Verificador de existencia
     * @param newPathObj: Path.
     * @return True si existe la ruta en el FileSystem o no
     * @author Byron Caices
     *
     */
    @Override
    public boolean existingPath(Path_20915795_CaicesLima newPathObj){

        String newpath = newPathObj.pathToString();
        ArrayList<String> pathStrings = new ArrayList<>();
        for(Item_20915795_CaicesLima item : content ){
            pathStrings.add(item.getLocation().pathToString());
        }

        if (pathStrings.contains(newpath)){
            return true;
        }
        return false;
    }
    //__________________________________________________________________________________________________________
    /**
     * Descripción: Verificador de existencia
     * @param newpath: String (ruta).
     * @return True si existe la ruta en el FileSystem o no
     * @author Byron Caices
     *
     */
    @Override
    public boolean existingPath(String newpath){

        //String newpath = newPathObj.pathToString();
        ArrayList<String> pathStrings = new ArrayList<>();
        for(Path_20915795_CaicesLima path : paths ){
            pathStrings.add(path.pathToString());
        }

        if (pathStrings.contains(newpath)){
            return true;
        }
        return false;
    }

    //################################# GETTERS & SETTERS ######################################
    /**
     * Descripción: Selector
     * @return La fecha del System.
     * @author Byron Caices
     *
     */
    @Override
    public Date getSystemDate() {
        return systemDate;
    }
    //__________________________________________________________________________________________________________
    /**
     * Descripción: Selector
     * @return Usuario logeado en el System.
     * @author Byron Caices
     *
     */
    @Override
    public User_20915795_CaicesLima getLogedUser() {
        return logedUser;
    }
    //__________________________________________________________________________________________________________
    /**
     * Descripción: Selector
     * @return Ruta actual del System.
     * @author Byron Caices
     *
     */
    @Override
    public Path_20915795_CaicesLima getCurrentPath() {
        return currentPath;
    }
    //__________________________________________________________________________________________________________

    /**
     * Descripción: Modificador
     * @param systemName: String
     * @author Byron Caices
     *
     */
    @Override
    public void setSystemName(String systemName) {
        systemName.toLowerCase();
        this.systemName = systemName;
    }

    //################################# OBJECT TO STRING ######################################
    /**
     * Descripción: toString
     * @return Objeto FileSystem como String
     * @author Byron Caices
     *
     */
    @Override
    public String toString() {
        return "\n\t\t|----------------------------|\n" +
               "\t\t|       TU FileSystem        |\n" +
               "\t\t|----------------------------|\n" +
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
    //_____________________________________      fin      _________________________________________

}

