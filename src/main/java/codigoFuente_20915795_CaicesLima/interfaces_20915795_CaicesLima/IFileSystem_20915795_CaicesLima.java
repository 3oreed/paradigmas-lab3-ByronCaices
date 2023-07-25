package codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.Drive_20915795_CaicesLima;
import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.File_20915795_CaicesLima;
import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.Path_20915795_CaicesLima;
import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.User_20915795_CaicesLima;

import java.util.Date;

public interface IFileSystem_20915795_CaicesLima {

    //################################ RF: LAB 3 ######################################

    void addDrive(String letter, String name, int cap);
    void register(String newUserName);
    void login(String userName);
    void logout();
    void switchDrive(String letter);
    void mkdir(String folderName);
    void cd(String pathname);
    void addFile(File_20915795_CaicesLima newfile);
    void del(String filepathern);
    void copy(String filepathern,String targetPath);

    //################################### VERIFICADORES DE EXISTENCIA ########################################

    boolean existingUser(String username);
    boolean existingLetter(String letter);
    boolean existingDrive(Drive_20915795_CaicesLima newdrive);
    boolean existingPath(Path_20915795_CaicesLima newPathObj);
    boolean existingPath(String newpath);

    //################################# GETTERS & SETTERS ######################################

    Date getSystemDate();
    User_20915795_CaicesLima getLogedUser();
    Path_20915795_CaicesLima getCurrentPath();
    void setSystemName(String systemName);

    //################################# OBJECT TO STRING ######################################
    String toString();
}
