package codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IPath_20915795_CaicesLima;

public class Path_20915795_CaicesLima implements IPath_20915795_CaicesLima {

    private String ruta;

    /**
     * Descripción: Constructor Path null
     * @author Byron Caices
     */
    public Path_20915795_CaicesLima() {
        this.ruta = "";
    }

    /**
     * Descripción: Constructor Path
     * @param path:String ruta
     * @author Byron Caices
     */
    public Path_20915795_CaicesLima(String path) {
        this.ruta = path;
    }

    /**
     * Descripción: Verifica si un path es raiz o no
     * @return true or false
     * @author Byron Caices
     */
    @Override
    public boolean isRoot(){
        if (ruta.length() == 3){
            return true;
        }
        return false;
    }

    //crea un nuevo path
    /**
     * Descripción: Crea ruta de un folder
     * @param foldername:Nombre del folder
     * @return ruta del folder
     * @author Byron Caices
     */
    @Override
    public String appendFolder(String foldername){
        String newPath = ruta + foldername + "/";
        return newPath;
    }

    /**
     * Descripción: Modifica ruta para entrar a un folder
     * @param foldername:Nombre del folder
     * @author Byron Caices
     */
    @Override
    public void enterFolder(String foldername){
        this.ruta = ruta + foldername + "/";
        //return newPath;
    }


    /**
     * Descripción: Crea ruta para volder a folder padre
     * @return Ruta padre
     * @author Byron Caices
     */
    @Override
    public String backToFolderPadre() {

        //c:/folder1/ -> c:/folder1
        String aux = ruta.substring(0,ruta.length()-1);
        int ultimoIndice = aux.lastIndexOf("/");
        String res = "";

        if (ultimoIndice > 0 && !isRoot()){

            //this.ruta = aux.substring(0,ultimoIndice+1);
            res = aux.substring(0,ultimoIndice+1);

        }
        return res;
    }


    /**
     * Descripción: Crea y modifica ruta para volder a raiz del sistema
     * @return Ruta padre
     * @author Byron Caices
     */
    @Override
    public String backToRoot() {
        //  "c:/folder1/folder11"
        //  "c:/folder1/"
        if (!isRoot()){
            this.ruta = ruta.substring(0,3);
            return ruta;
        }
        return ruta;
    }

    /**
     * Descripción: Retorna ruta string del path
     * @return Ruta string
     * @author Byron Caices
     */
    @Override
    public String getRuta(){
        return ruta;

    }

    /**
     * Descripción: Modifica ruta del path
     * @param nuevaruta: Nueva ruta
     * @author Byron Caices
     */
    @Override
    public void setRuta(String nuevaruta){
        this.ruta = nuevaruta;
    }

    /**
     * Descripción: Convierte path a string
     * @return path como string
     * @author Byron Caices
     */
    @Override
    public String pathToString() {
        return ruta;
    }

    /**
     * Descripción: Convierte objeto path a string
     * @return path como string
     * @author Byron Caices
     */
    @Override
    public String toString() {
        return ruta+"\n               ";
    }


}
