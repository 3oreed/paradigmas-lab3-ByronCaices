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


    public Item() {}

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public Path getLocation() {
        return location;
    }

    public void setLocation(Path location) {
        this.location = location;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*
    public Item(String name, FileSystem fl){
        this.itemName = name;
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = fl.getCurrentPath();
        this.creator = fl.getLogedUser();
        //this.extension
    }
 */
}
