package myfilesystem.models;

public interface IFile extends IItem {
    String getExtFromName(String filename);
    String getExtension();
    void setExtension(String extension);
    String getText();
    void setText(String text);
    String toString();
}
