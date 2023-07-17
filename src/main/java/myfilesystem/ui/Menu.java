package myfilesystem.ui;

import myfilesystem.models.File;
import myfilesystem.models.FileSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    int opcion;
    List<String> opsHistory;

    public Menu() {
        this.opcion = 0;
    }

    public boolean menu(){
        Scanner input = new Scanner(System.in);
        Scanner subinput = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 13;

        int choice;
        String subchoice;
        boolean flag;
        flag = false;
        opsHistory = new ArrayList<>();

        FileSystem fileSystem = new FileSystem();

        do {
            printMenu();
            choice = input.nextInt();
            //String subchoice = "";

            switch (choice) {
                case 0:
                    //do something
                    if (flag) {
                        System.out.println("---------------------------------------------------------");
                        System.out.println(fileSystem);
                        opsHistory.add("Se visualizó el sistema");
                        break;
                    }
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Aun no has creado un Sistema de Archivos");
                    break;

                case 1:
                    //Se crea antes del DO-WHILE pero lo renombramos
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Crear Sistema de Archivos #\n\nIngresa un nombre para tu sistema: ");
                    flag = true;
                    subchoice = subinput.nextLine().toLowerCase();
                    fileSystem.setSystemName(subchoice);
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Sistema <"+subchoice+"> creado con exito! \n");
                    opsHistory.add("Se creo el sistema "+subchoice);
                    break;

                case 2:
                    //do something
                    break;

                case 3:
                    System.out.println("Sum 2 numbers");
                    System.out.println("Ingrese un número int y luego presione ENTER:");
                    var n1 = input.nextInt();
                    System.out.println("Ingrese otro número int y luego presione ENTER:");
                    var n2 = input.nextInt();
                    int sum = n1 + n2;
                    System.out.println("La suma es: " + sum);
                    break;

                case 4:
                    //do something
                    break;

                case 13:
                    System.out.println("Bye.. Que la Fuerza te acompañe");
                    System.exit(0);
                    break;
                case 14:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("\n# Historial de Operaciones");
                    int n;
                    n = 1;
                    for (String op : opsHistory){
                        System.out.println(n.+op);
                    }
                    //System.out.println(opsHistory);
                    break;
                default:
                    System.out.println(choice + " is not a valid option! Please select correct option.");

            }
        } while (choice != MENU_EXIT_OPTION);
        return true;
    }

    private static void printMenu() {
        System.out.println("---------------------------------------------------------");
        System.out.println("\n### SISTEMA DE ARCHIVOS ###");
        System.out.print(" 0. Visualizar Sistema de Archivos\n");
        System.out.print(" 1. Crear Sistema de Archivos\n");
        System.out.print(" 2. Anadir UNIDAD al Sistema.\n");
        System.out.print(" 3. Registrar USUARIO en el Sistema.\n");
        System.out.print(" 4. Iniciar Sesion con USUARIO en el Sistema.\n");
        System.out.print(" 5. Cerrar Sesiones del Sistema.\n");
        System.out.print(" 6. Cambiar de UNIDAD.\n");
        System.out.print(" 7. Crear Directorio en la ruta actual del Sistema.\n");
        System.out.print(" 8. Cambiar directorio/ruta actual del Sistema.\n");
        System.out.print(" 9. Crear un archivo y agregar a ruta actual.\n"); //crea archivo y ademas hace addfile
        System.out.print("10. Eliminar todos los archivos de la ruta actual.\n");
        System.out.print("11. Eliminar un archivo de la ruta actual.\n");
        System.out.print("12. Eliminar archivos dada su extension de la ruta actual.\n");
        System.out.print("13. Finalizar Programa.\n");
        System.out.print("14. Ver historial de Operaciones.\n");
        System.out.print("\nIndica la operación que quieres realizar: ");
    }

}

/*
private static void printMenu() {
        System.out.println("Main Menu\n");
        System.out.print("1. Create something \n");
        System.out.print("2. Modify something.\n");
        System.out.print("3. Sum 2 numbers.\n");
        System.out.print("4. Some option.\n");
        System.out.print("5. Exit\n");
        System.out.print("\nEnter your choice: ");
    }
 */
