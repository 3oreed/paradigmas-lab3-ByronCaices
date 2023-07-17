package myfilesystem.models;

import myfilesystem.interfaces.IPath;

public class Path implements IPath {
    String ruta;

    public Path() {
        this.ruta = "";
    }

    public Path(String path) {
        this.ruta = path;
    }

    public boolean isRoot(){
        if (ruta.length() == 3){
            return true;
        }
        return false;
    }

    //crea un nuevo path
    public String appendFolder(String foldername){
        String newPath = ruta + foldername + "/";
        return newPath;
    }

    public void enterFolder(String foldername){
        this.ruta = ruta + foldername + "/";
        //return newPath;
    }




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



    public String backToRoot() {
        //  "c:/folder1/folder11"
        //  "c:/folder1/"
        if (!isRoot()){
            this.ruta = ruta.substring(0,3);
            return ruta;
        }
        return ruta;
    }

    public String pathToString() {
        return ruta;
    }

    @Override
    public String toString() {
        return ruta+"\n               ";
    }


// "c:/folder1/folder11/"
    //  cd
}
