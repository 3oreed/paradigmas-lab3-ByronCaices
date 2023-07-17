package codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IDrive_20915795_CaicesLima;

public class Drive_20915795_CaicesLima implements IDrive_20915795_CaicesLima {
    private String letter;
    private String nombre;
    private int cap;

    /**
     * Descripción: Constructor del drive
     * @param letter: letra de la unidad
     * @param nombre: nombre de la unidad
     * @param cap: capacidad de la unidad
     * @author Byron Caices
     *
     */
    public Drive_20915795_CaicesLima(String letter, String nombre, int cap) {
        this.letter = letter.toLowerCase();
        this.nombre = nombre.toLowerCase();
        this.cap = cap;
    }


    /**
     * Descripción: Selector
     * @return La letra de la unidad.
     * @author Byron Caices
     *
     */
    @Override
    public String getLetter() {
        return letter;
    }


    /**
     * Descripción: toString
     * @return Objeto Drive como String
     * @author Byron Caices
     *
     */
    @Override
    public String toString() {
        return "Drive{" +
                "letter='" + letter + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cap=" + cap +
                '}';
    }
}
