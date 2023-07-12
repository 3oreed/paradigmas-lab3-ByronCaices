package myfilesystem.models;

import java.util.Date;

public class Folder extends Item{

    public Folder(){
        this.itemName = "";
        this.createDate = null;
        this.modDate = null;
        this.location = "";
        this.creator = "";
    }

    public Folder(String name, FileSystem fl){
        this.itemName = name;
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = fl.getCurrentPath();
        this.creator = fl.getLogedUser().getUserName();
    }

    public Folder(String name){
        this.itemName = name;
        this.createDate = null;
        this.modDate = null;
        this.location = "";
        this.creator = "";
    }

    @Override
    public String getItemName() {
        return super.getItemName();
    }

    @Override
    public void setItemName(String itemName) {
        super.setItemName(itemName);
    }

    @Override
    public Date getCreateDate() {
        return super.getCreateDate();
    }

    @Override
    public void setCreateDate(Date createDate) {
        super.setCreateDate(createDate);
    }

    @Override
    public Date getModDate() {
        return super.getModDate();
    }

    @Override
    public void setModDate(Date modDate) {
        super.setModDate(modDate);
    }

    @Override
    public String getLocation() {
        return super.getLocation();
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    @Override
    public String getCreator() {
        return super.getCreator();
    }

    @Override
    public void setCreator(String creator) {
        super.setCreator(creator);
    }

    @Override
    public String toString() {
        return "Folder{" +
                "itemName='" + itemName + '\'' +
                ", createDate=" + createDate +
                ", modDate=" + modDate +
                ", location='" + location + '\'' +
                ", creator=" + creator +
                '}';
    }
}
