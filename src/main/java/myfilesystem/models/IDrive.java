package myfilesystem.models;

public interface IDrive {
    String getLetter();
    void setLetter(String letter);
    String getNombre();
    void setNombre(String nombre);
    int getCap();
    void setCap(int cap);
    String toString();
}

