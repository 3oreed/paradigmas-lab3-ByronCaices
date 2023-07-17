package myfilesystem.models;

import myfilesystem.interfaces.IDrive;

public class Drive implements IDrive {
    String letter;
    String nombre;
    int cap;

    public Drive(String letter, String nombre, int cap) {
        this.letter = letter.toLowerCase();
        this.nombre = nombre.toLowerCase();
        this.cap = cap;
    }

    public String getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return "Drive{" +
                "letter='" + letter + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cap=" + cap +
                '}';
    }
}
