package codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IUser_20915795_CaicesLima;

public class User_20915795_CaicesLima implements IUser_20915795_CaicesLima {
    private String userName;

    /**
     * Descripción: Constructor User
     * @param userName:String nombre del user
     * @author Byron Caices
     */
    public User_20915795_CaicesLima(String userName) {
        this.userName = userName;
    }

    /**
     * Descripción: Constructor user null
     * @author Byron Caices
     */
    public User_20915795_CaicesLima() {
        this.userName = "";
    }

    /**
     * Descripción: Verifica user valido
     * @return true si es valid user
     * @author Byron Caices
     */
    @Override
    public boolean isUserNull() {
        if (userName == "") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Descripción: Selector
     * @return Nombre del usuario.
     * @author Byron Caices
     */
    @Override
    public String getUserName() {
        return userName;
    }


    /**
     * Descripción: toString
     * @return Objeto User como String
     * @author Byron Caices
     */
    @Override
    public String toString() {
        return userName;
    }
}
