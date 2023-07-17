package myfilesystem.interfaces;

public interface IFile extends IItem {
    // Por ahora, esta interfaz hereda todos los métodos de IItem
    String getExtFromName(String filename);
    String toString();
}
