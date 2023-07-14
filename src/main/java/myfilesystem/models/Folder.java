package myfilesystem.models;

import myfilesystem.interfaces.IFolder;

import java.util.Date;

public class Folder extends Item implements IFolder {

    public Folder(){
        this.itemName = "";
        this.createDate = null;
        this.modDate = null;
        this.location = null;
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
        this.location = null;
        this.creator = "";
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
