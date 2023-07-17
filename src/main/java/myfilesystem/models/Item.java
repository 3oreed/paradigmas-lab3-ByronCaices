package myfilesystem.models;

import myfilesystem.interfaces.IItem;

import java.util.Date;

public abstract class Item implements IItem {

    String itemName;
    Date createDate;
    Date modDate;
    Path location;
    String creator; //nombre del creador y ya
    //String extension;
    String extension;
    String text;


    public Item() {
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

    public abstract Path getLocation();

    public abstract void setLocation(Path location);


    public abstract void setCreator(String creator);

    public abstract String getExtension();

    public abstract void setExtension(String extension);

    public abstract String getText();

    public abstract void setText(String text);

    public abstract boolean isFile();





}
