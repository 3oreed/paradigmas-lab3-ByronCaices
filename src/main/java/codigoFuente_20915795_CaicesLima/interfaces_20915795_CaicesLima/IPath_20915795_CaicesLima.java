package codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima;

public interface IPath_20915795_CaicesLima {
    public boolean isRoot();
    public String appendFolder(String foldername);
    public void enterFolder(String foldername);
    public String backToFolderPadre();
    public String backToRoot();
    public String pathToString();
    public String toString();
    public String getRuta();
    public void setRuta(String nuevaruta);
}
