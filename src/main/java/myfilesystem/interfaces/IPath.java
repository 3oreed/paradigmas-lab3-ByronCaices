package myfilesystem.interfaces;

public interface IPath {
    public boolean isRoot();
    public String appendFolder(String foldername);
    public void enterFolder(String foldername);
    public String backToFolderPadre();
    public String backToRoot();
    public String pathToString();
    public String toString();
}
