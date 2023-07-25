package codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IFolder_20915795_CaicesLima;

import java.util.Date;

public class Folder_20915795_CaicesLima extends Item_20915795_CaicesLima implements IFolder_20915795_CaicesLima {

    /**
     * Descripción: Constructor folder
     * @param name:String nombre del directorio
     * @author Byron Caices
     */
    public Folder_20915795_CaicesLima(String name) {
        name.toLowerCase();
        this.itemName = name;
        this.createDate = null;
        this.modDate = null;
        this.location = null;
        this.creator = "";
    }


    /**
     * Descripción: Selector
     *
     * @return Nombre del folder.
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
     * @return hora de modificacion del folder
     * @author Byron Caices
     */
    @Override
    public Date getModDate() {
        return getModDate();
    }


    /**
     * Descripción: Modificador hora del folder
     * @param modDate: String
     * @author Byron Caices
     *
     */
    @Override
    public void setModDate(Date modDate) {
        this.modDate = modDate;

    }


    /**
     * Descripción: Selector
     * @return ubicacion del folder respecto al System.
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
     * Descripción: Verificador de tipo
     * @return false si es folder
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
     * Descripción: toString
     * @return Objeto Folder como String
     * @author Byron Caices
     *
     */
    @Override
    public String toString() {
        return "Folder{" +
                "itemName='" + itemName + '\'' +
                ", createDate=" + createDate +
                ", modDate=" + modDate +
                ", location='" + location + '\'' +
                ", creator=" + creator +
                '}'+"\n              ";
    }

    @Override
    public String getExtension() {
        return extension;
    }
    @Override
    public void setExtension(String extension) {
        this.extension=extension;
    }
    @Override
    public String getText() {
        return text;
    }
    @Override
    public void setText(String text) {
        this.text=text;

    }
    @Override
    public Folder_20915795_CaicesLima itemClone(){

        Folder_20915795_CaicesLima newFolder = new Folder_20915795_CaicesLima("");

        newFolder.itemName = itemName;
        newFolder.createDate = createDate;
        newFolder.modDate = modDate;
        newFolder.location = location;
        newFolder.creator = creator;
        newFolder.extension = "";
        newFolder.text = "";

        return newFolder;
    }
}
