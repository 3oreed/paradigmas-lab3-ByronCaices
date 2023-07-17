package codigoFuente_20915795_CaicesLima.ui_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IMenu_20915795_CaicesLima;
import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.File_20915795_CaicesLima;
import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.FileSystem_20915795_CaicesLima;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu_20915795_CaicesLima implements IMenu_20915795_CaicesLima {

    private int opCounter;
    private List<String> opsHistory;
    private FileSystem_20915795_CaicesLima fileSystem;

    /**
     * Descripción: Constructor menu
     * @author Byron Caices
     */
    public Menu_20915795_CaicesLima() {
        this.opCounter = 0;
    }

    /**
     * Descripción: Menu del sistema, se encarga de realizar operaciones sobre el sistema
     * @author Byron Caices
     */
    public void menu(){
        Scanner input = new Scanner(System.in);

        final int MENU_EXIT_OPTION = 13;

        int choice;
        boolean flag;
        flag = false;
        opsHistory = new ArrayList<>();

        this.fileSystem = new FileSystem_20915795_CaicesLima("");

        do {


            printMenu();
            choice = input.nextInt();
            //String subchoice = "";

            switch (choice) {

                case 0:
                    // VISUALIZAR SISTEMA DE ARCHIVOS
                    if (flag) { // Si esta creado
                        System.out.println("---------------------------------------------------------");
                        System.out.println(fileSystem);
                        opsHistory.add("visualize: Se visualizó el sistema <-- "+new Date());
                        break;
                    }
                    //Si no esta creado
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\nAun no has creado un Sistema de Archivos");
                    break;

                case 1:
                    if (flag) {
                        if (!fileSystem.getCurrentPath().pathToString().equals("") ) { //&& flag
                            String currentPath = fileSystem.getCurrentPath().pathToString();
                            System.out.println("---------------------------------------------------------");
                            System.out.println("\n# Ruta Actual del Sistema");
                            System.out.println("    >> " + currentPath);
                            break;
                        }
                    }
                    else{
                        System.out.println("---------------------------------------------------------");
                        System.out.println("\nAun no has creado un Sistema de Archivos o fijado una ruta");
                    }


                    break;

                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Historial de Operaciones");
                    this.opCounter = 0;
                    for (String op : opsHistory){
                        this.opCounter = opCounter + 1;
                        System.out.println(opCounter +". >> "+op);
                    }

                    break;
                case 3:
                    // Crear entradas
                    Scanner input1 = new Scanner(System.in);
                    String systemName = "";

                    //Se crea antes del DO-WHILE pero lo renombramos
                    // Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Crear Sistema de Archivos #\n\nIngresa un nombre para tu sistema: ");

                    //Metodo
                    flag = true;
                    systemName = input1.nextLine().toLowerCase();
                    fileSystem.setSystemName(systemName);

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\nSistema <"+systemName+"> creado con exito!");
                    opsHistory.add("filesystem: Se creo el sistema "+systemName+ " <-- " + new Date());
                    break;

                case 4:
                    //Crear entradas
                    Scanner inputDriveName = new Scanner(System.in);
                    Scanner inputLetter = new Scanner(System.in);
                    Scanner inputCap = new Scanner(System.in);
                    String driveName;
                    String letter;
                    int cap;
                    boolean driveflag;
                    driveflag = false;
                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Anadir UNIDAD al Sistema #\n");

                    //Pedir al usuario valores y asignarlos
                    do {
                        if (driveflag){
                            System.out.println("Error al agregar unidad: la letra debe ser solo UNA\n");
                        }
                        System.out.println("Ingresa un NOMBRE de tu UNIDAD: ");
                        driveName = inputDriveName.nextLine().toLowerCase();

                        System.out.println("Ingresa una LETRA de tu UNIDAD: ");
                        letter = inputLetter.nextLine().toLowerCase();

                        System.out.println("Ingresa CAPACIDAD de tu UNIDAD: ");
                        cap = inputCap.nextInt();
                        driveflag = true;

                    }while(letter.length()>1);

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo + addOp
                    if (!fileSystem.existingLetter(letter))
                        //Si no existe la letra yo agrego la op
                        opsHistory.add("addDrive: Se agregó "+driveName+ " al Sistema" + " <-- " + new Date());

                    fileSystem.addDrive(letter,driveName,cap);
                    break;

                case 5:
                    //Crear entradas
                    Scanner inputRegisterUser = new Scanner(System.in);
                    String registerUserName;

                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Registrar USUARIO en el Sistema #\n");

                    //Pedir al usuario valores y asignarlos
                    System.out.println("Ingresa un User Name: ");
                    registerUserName = inputRegisterUser.nextLine().toLowerCase();

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    if (!fileSystem.existingUser(registerUserName))
                        opsHistory.add("register: Se registro "+registerUserName+ " en el Sistema" + " <-- " + new Date());

                    fileSystem.register(registerUserName);
                    break;

                case 6:
                    //Crear entradas
                    Scanner inputLoginUser = new Scanner(System.in);
                    String loginUserName;

                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Iniciar Sesion con USUARIO en el Sistema #\n");

                    //Pedir al usuario valores y asignarlos
                    System.out.println("Ingresa un User Name: ");
                    loginUserName = inputLoginUser.nextLine().toLowerCase();

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    if (fileSystem.getLogedUser().isUserNull() && fileSystem.existingUser(loginUserName))
                        opsHistory.add("login: Se inicio sesion con "+loginUserName+ " en el Sistema" + " <-- " + new Date());

                    fileSystem.login(loginUserName);
                    break;

                case 7:
                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Cerrar Sesiones del Sistema #\n");

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    fileSystem.logout();
                    opsHistory.add("logout: Se cerraron todas las sesiones del sistema" + " <-- " + new Date());
                    break;
                case 8:
                    //Crear entradas
                    Scanner inputSwitchDrive = new Scanner(System.in);
                    String letterSwitch;

                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Cambiar de UNIDAD #\n");

                    //Pedir al usuario valores y asignarlos
                    System.out.println("Ingresa un la letra de la unidad que quieres usar: ");
                    letterSwitch = inputSwitchDrive.nextLine().toLowerCase();

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    if (fileSystem.existingLetter(letterSwitch) && !fileSystem.getLogedUser().isUserNull())
                        opsHistory.add("switchDrive: Se cambio a la unidad "+ letterSwitch.toUpperCase()+ " <-- " + new Date());

                    fileSystem.switchDrive(letterSwitch);
                    break;
                case 9:
                    //Crear entradas
                    Scanner inputMkdir = new Scanner(System.in);
                    String foldername;

                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Crear Directorio en la ruta actual del Sistema #\n");

                    //Pedir al usuario valores y asignarlos
                    System.out.println("Ingresa nombre del directorio: ");
                    foldername = inputMkdir.nextLine().toLowerCase();

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    String newPath = fileSystem.getCurrentPath().pathToString() + foldername + "/";
                    if (!fileSystem.existingPath(newPath))
                        opsHistory.add("mkdir: Se creo el directorio "+foldername.toLowerCase()+ " <-- " + new Date());

                    fileSystem.mkdir(foldername);
                    break;
                case 10:
                    //Crear entradas
                    Scanner inputCd = new Scanner(System.in);
                    String pathname;

                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Cambiar directorio/ruta actual del Sistema #\n");

                    //Pedir al usuario valores y asignarlos
                    System.out.println(" \"/\"  : Para volver a la raiz del sistema\n");
                    System.out.println("\"..\"  : Para volver al directorio anterior\n");
                    System.out.println("dirname : Para ENTRAR al directorio deseado, ej: folder1\n");
                    System.out.println("dirname/subdirname/... : Para ENTRAR directamente al directorio deseado, ej: folder1/folder11\n\n");
                    System.out.println("Ingresa alguna opcion, path o nombre del directorio: ");
                    pathname = inputCd.nextLine().toLowerCase();

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    String newCdPath = fileSystem.getCurrentPath().pathToString() + pathname + "/";
                    if (pathname.equals("..")){
                        fileSystem.cd(pathname);
                        opsHistory.add("cd: Se regreso a carpeta padre" + " <-- " + new Date());

                    }else if (pathname.equals("/")){
                        fileSystem.cd(pathname);
                        opsHistory.add("cd: Se regreso a raiz del sistema" + " <-- " + new Date());
                    }
                    else if(fileSystem.existingPath(newCdPath)){
                        fileSystem.cd(pathname);
                        opsHistory.add("cd: Se fijo la ruta = " +newCdPath+ " <-- " + new Date());
                    }
                    //fileSystem.cd(pathname);
                    break;

                case 11:

                    //Crear entradas
                    Scanner inputFileName = new Scanner(System.in);
                    Scanner inputFileText = new Scanner(System.in);
                    Scanner inputYN = new Scanner(System.in);
                    String addfilename;
                    String addfiletext;
                    addfiletext = "";
                    String addYN;
                    addYN = "";
                    boolean addfileflag;
                    addfileflag = false;

                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Crear un archivo y agregar a ruta actual #\n");

                    //Pedir al usuario valores y asignarlos

                    do {
                        if (addfileflag)
                            System.out.println("\n  **Intenta un nombre de archivo valido ^.^");

                        System.out.println("Ingresa nombre de tu archivo junto con su extension (Ej: myfile.txt) : ");
                        addfilename = inputFileName.nextLine().toLowerCase();

                        addfileflag = true;

                    }while(!addfilename.contains("."));

                    System.out.println("¿Quieres anadir texto/contenido a tu archivo? Y/N: ");
                    addYN = inputYN.nextLine().toUpperCase();

                    if (addYN.equals("Y")){
                        System.out.println("Ingresa texto/contenido de tu archivo: ");
                        addfiletext = inputFileText.nextLine().toLowerCase();
                    }

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    File_20915795_CaicesLima newFile = new File_20915795_CaicesLima(addfilename,fileSystem);
                    newFile.setText(addfiletext);
                    fileSystem.addFile(newFile);
                    opsHistory.add("addFile: Se agrego el archivo "+addfilename+ " en la ruta actual <-- " + new Date());
                    break;

                case 12:
                    //Crear entradas
                    Scanner inputFilePathern = new Scanner(System.in);
                    String filePathern;

                    //Crear encabezado opcion
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Eliminar Item/s <File/Folder> de la ruta actual #\n");

                    //Pedir al usuario valores y asignarlos

                    System.out.println("  **Obs: Los items eliminados seran anadidos a la papelera\n\n");
                    System.out.println("\"*.*\" o \"*\"        Para eliminar todos los archivos de la ruta actual\n");
                    System.out.println("\"*.extension\"        Para eliminar todos los archivos .extension de la ruta actual\n");
                    System.out.println("\"filename.extension\" Para eliminar el archivo deseado de la ruta actual\n");
                    System.out.println("\"foldername\"         Para eliminar el directorio y su contenido deseado de la ruta actual\n\n");


                    System.out.println("Ingresa un comando, filename o foldername: ");
                    filePathern = inputFilePathern.nextLine().toLowerCase();

                    //Cerrar encabezado opcion
                    System.out.println("---------------------------------------------------------");

                    //Metodo+addOp
                    if (filePathern.contains("*.") && filePathern.length()>3)
                        opsHistory.add("del: Se eliminaron los archivos "+ filePathern+ " de la ruta actual <-- " + new Date());
                    else if (filePathern.equals("*") || filePathern.equals("*.*"))
                        opsHistory.add("del: Se eliminaron todos los archivos de la ruta actual <-- " + new Date());
                    else if (filePathern.contains(".") && !filePathern.contains("*"))
                        opsHistory.add("del: Se elimino el archivo "+filePathern+" de la ruta actual <-- " + new Date());
                    else opsHistory.add("del: Se elimino el directorio "+filePathern+" y su contenido de la ruta actual <-- " + new Date());

                    fileSystem.del(filePathern);
                    break;

                case 13:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n----------------- PROGRAMA FINALIZADO -------------------");
                    System.out.println("\n---------------------------------------------------------");
                    System.exit(0);
                    break;

                default:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n>> "+choice + " no es una opcion valida! Selecciona una opcion correcta.");

            }
            if (!fileSystem.getCurrentPath().pathToString().equals(""))
                System.out.println("\nRuta Actual >>\n"+
                                   "               "+fileSystem.getCurrentPath().pathToString());

        } while (choice != MENU_EXIT_OPTION);
        //return true;
    }

    /**
     * Descripción: Imprime menu por consola
     * @author Byron Caices
     */
    public void printMenu() {
        System.out.println("\n---------------------------------------------------------");

        System.out.println("\n### MANIPULADOR DE SISTEMA DE ARCHIVOS ###\n");
        System.out.print(" 0. Visualizar Sistema de Archivos.\n");
        System.out.print(" 1. Visualizar Ruta Actual del Sistema.\n");
        System.out.print(" 2. Ver historial de Operaciones Concretadas.\n\n");

        System.out.print(" 3. Crear Sistema de Archivos (filesystem)\n");
        System.out.print(" 4. Anadir UNIDAD al Sistema (addDrive)\n");
        System.out.print(" 5. Registrar USUARIO en el Sistema (register)\n");
        System.out.print(" 6. Iniciar Sesion con USUARIO en el Sistema (login)\n");
        System.out.print(" 7. Cerrar Sesiones del Sistema(logout)\n");
        System.out.print(" 8. Cambiar de UNIDAD (switchDrive)\n");
        System.out.print(" 9. Crear Directorio en la ruta actual del Sistema (mkdir)\n");
        System.out.print("10. Cambiar directorio/ruta actual del Sistema (cd)\n");
        System.out.print("11. Crear un archivo y agregar a ruta actual (addFile)\n"); //crea archivo y ademas hace addfile
        System.out.print("12. Eliminar Item/s <File/Folder> de la ruta actual (del)\n");
        System.out.print("13. Finalizar Programa.\n");

        System.out.print("\nIndica la operación que quieres realizar: ");
    }

}

//Crear entradas

//Crear encabezado opcion

//Pedir al usuario valores y asignarlos

//Cerrar encabezado opcion

//Metodo+addOp
