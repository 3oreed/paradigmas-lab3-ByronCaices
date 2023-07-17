package myfilesystem;

import myfilesystem.models.File;
import myfilesystem.models.FileSystem;
import myfilesystem.models.Path;
import myfilesystem.ui.Menu;

public class Main {


    public static void main(String[] args) {


        Menu myMenu = new Menu();
        myMenu.menu();


    }
/*
    var filesystem = new FileSystem("mi Sistema");
        System.out.println(filesystem);
        filesystem.addDrive("C", "myDrive", 100);
        filesystem.addDrive("C", "repEtido", 550);
        filesystem.addDrive("D", "mydrivE99", 554);
        filesystem.addDrive("D", "otrO mas", 555);

        System.out.println(filesystem);

        filesystem.register("user1");
        filesystem.register("uSer1");

        System.out.println(filesystem);

        filesystem.login("uSer2");
        filesystem.login("uSer1");

        filesystem.register("USEr2");
        filesystem.logout();
        filesystem.login("uSeR2");

    //System.out.println(filesystem);

        filesystem.switchDrive("C");
        System.out.println(filesystem);

    //filesystem.setCurrentPath("c:/");
        filesystem.mkdir("folder1");
        filesystem.cd("folder1");
        filesystem.mkdir("folder2");
        filesystem.mkdir("fOlder2");

        filesystem.cd("folder2");
        System.out.println(filesystem);


    myfilesystem.models.File file1A = new File("file1A.txt",filesystem);
    myfilesystem.models.File file1B = new File("file1B.doc",filesystem);
    myfilesystem.models.File file1C = new File("file1C.txt",filesystem);
    myfilesystem.models.File file2A = new File("file2A.txt",filesystem);
    myfilesystem.models.File file2B = new File("file2B.doc",filesystem);
    myfilesystem.models.File file2C = new File("file2C.doc",filesystem);


        filesystem.addFile(file1A);
        filesystem.addFile(file1B);
        filesystem.addFile(file1C);
        filesystem.cd("..");
        filesystem.addFile(file2A);
        filesystem.addFile(file2B);
        filesystem.addFile(file2C);

        System.out.println(filesystem);

        filesystem.del("file1.txt");
        System.out.println(filesystem);
        */


}


