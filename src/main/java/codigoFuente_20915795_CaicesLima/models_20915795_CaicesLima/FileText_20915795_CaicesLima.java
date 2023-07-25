package codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IFile_20915795_CaicesLima;

import java.util.Date;

public class FileText_20915795_CaicesLima extends File_20915795_CaicesLima implements IFile_20915795_CaicesLima {

    /**
     * Descripción: Constructor file
     * @param name:String nombre del file con extension
     * @param fl: FileSystem para obtener metadata
     * @author Byron Caices
     */
    public FileText_20915795_CaicesLima(String name, FileSystem_20915795_CaicesLima fl){
        name.toLowerCase();
        this.itemName = name.toLowerCase();
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = new Path_20915795_CaicesLima(fl.getCurrentPath().pathToString()+itemName);
        this.creator = fl.getLogedUser().getUserName();
        this.extension = getExtFromName(name);
        this.text = "";
    }

    public FileText_20915795_CaicesLima(){
        //name.toLowerCase();
        this.itemName ="";
        this.createDate = new Date();
        this.modDate = new Date();
        this.location = new Path_20915795_CaicesLima();
        this.creator = "";
        this.extension = "";
        this.text = "";
    }

    /**
     * Descripción: Selector
     *
     * @return Nombre del file.
     * @author Byron Caices
     */
    @Override
    public String getItemName() {
        return itemName;
    }


    /**
     * Descripción: Modificador
     * @param createDate: Date
     * @author Byron Caices
     *
     */
    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;

    }

    /**
     * Descripción: Selector
     * @return hora de modificacion del file
     * @author Byron Caices
     */
    @Override
    public Date getModDate() {
        return getModDate();
    }


    /**
     * Descripción: Modificador hora del file
     * @param modDate: String
     * @author Byron Caices
     *
     */
    @Override
    public void setModDate(Date modDate) {
        this.modDate=modDate;

    }


    /**
     * Descripción: Selector
     * @return ubicacion del file respecto al System.
     * @author Byron Caices
     *
     */
    @Override
    public Path_20915795_CaicesLima getLocation() {
        return location;
    }


    /**
     * Descripción: Modificador
     * @param location: Path
     * @author Byron Caices
     *
     */
    @Override
    public void setLocation(Path_20915795_CaicesLima location) {
        this.location=location;

    }

    //@Override



    /**
     * Descripción: Modificador
     * @param creator: String
     * @author Byron Caices
     *
     */
    @Override
    public void setCreator(String creator) {
        this.creator=creator;
    }


    /**
     * Descripción: Selector
     * @return Extension del archivo
     * @author Byron Caices
     *
     */
    @Override
    public String getExtension() {
        return extension;
    }

    /**
     * Descripción: Modificador
     * @param extension: String
     * @author Byron Caices
     *
     */
    @Override
    public void setExtension(String extension) {
        this.extension=extension;

    }

    /**
     * Descripción: Modificador
     * @return Texto/contenido del archivo
     * @author Byron Caices
     *
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * Descripción: Modificador
     * @param text: String
     * @author Byron Caices
     *
     */
    @Override
    public void setText(String text) {
        this.text=text;

    }

    /**
     * Descripción: Verificador de tipo
     * @return true si es file
     * @author Byron Caices
     *
     */
    @Override
    public boolean isFile(){
        if (extension!=""){
            return true;
        }
        return false;
    }

    /**
     * Descripción: Selector
     * @return Extension del file
     * @author Byron Caices
     *
     */
    public String getExtFromName(String filename) {

        String extension = "";

        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex >= 0) {
            extension = filename.substring(dotIndex + 1);
        }
        return  extension;
        //System.out.println("La extensión del archivo es: " + extension);
    }

    /**
     * Descripción: toString
     * @return Objeto File como String
     * @author Byron Caices
     *
     */
    @Override
    public String toString() {
        return "File{" +
                "extension='" + extension + '\'' +
                ", text='" + text + '\'' +
                ", itemName='" + itemName + '\'' +
                ", location='" + location + '\'' +
                ", creator=" + creator +
                '}'+"\n              ";
    }

    /**
     * Descripción: Clona objeto
     * @return Copia por atributo del objeto al que se le aplica el metodo
     * @author Byron Caices
     *
     */
    @Override
    public FileText_20915795_CaicesLima itemClone(){

        FileText_20915795_CaicesLima newFile = new FileText_20915795_CaicesLima();

        newFile.itemName = itemName;
        newFile.createDate = createDate;
        newFile.modDate = modDate;
        newFile.location = location;
        newFile.creator = creator;
        newFile.extension = extension;
        newFile.text = text;

        return newFile;
    }
}
