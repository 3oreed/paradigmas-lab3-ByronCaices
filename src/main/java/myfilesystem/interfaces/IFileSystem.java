package myfilesystem.interfaces;

import myfilesystem.models.Drive;
import myfilesystem.models.File;
import myfilesystem.models.Path;
import myfilesystem.models.User;

import java.util.Date;

public interface IFileSystem {
    boolean existingUser(String username);
    boolean existingLetter(String letter);
    boolean existingDrive(Drive newdrive);
    void addDrive(String letter, String name, int cap);
    void register(String newUserName);
    void login(String userName);
    void logout();
    void switchDrive(String letter);
    boolean existingPath(Path newPathObj);
    boolean existingPath(String newpath);
    void mkdir(String folderName);
    void cd(String pathname);
    void addFile(File newfile);
    void del(String filepathern);
    String toString();
    Date getSystemDate();
    User getLogedUser();
    Path getCurrentPath();
    void setSystemName(String systemName);
}
