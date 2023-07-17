package codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima;

import codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima.IItem_20915795_CaicesLima;

import java.util.Date;

public abstract class Item_20915795_CaicesLima implements IItem_20915795_CaicesLima {

    protected String itemName;
    protected Date createDate;
    protected Date modDate;
    protected Path_20915795_CaicesLima location;
    protected String creator; //nombre del creador y ya
    protected String extension;
    protected String text;

    /**
     * Descripción: Constructor de un Item null
     * @author Byron Caices
     *
     */
    public Item_20915795_CaicesLima() {
        this.itemName = "";
        this.createDate = null;
        this.modDate = null;
        this.location = null;
        this.creator = "";
        this.extension = "";
        this.text = "";
    }

    public abstract String getItemName();
    public abstract void setCreateDate(Date createDate);
    public abstract Date getModDate();
    public abstract void setModDate(Date modDate);
    public abstract Path_20915795_CaicesLima getLocation();
    public abstract void setLocation(Path_20915795_CaicesLima location);
    public abstract void setCreator(String creator);
    public abstract String getExtension();
    public abstract void setExtension(String extension);
    public abstract String getText();
    public abstract void setText(String text);
    public abstract boolean isFile();

}
