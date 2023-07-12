package myfilesystem.models;

import java.util.Date;

public abstract class Item {

    String itemName;
    Date createDate;
    Date modDate;
    String location;
    String creator; //nombre del creador y ya
    //String extension;


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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
