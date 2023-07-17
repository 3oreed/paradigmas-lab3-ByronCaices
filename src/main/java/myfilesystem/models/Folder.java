package myfilesystem.models;

import myfilesystem.interfaces.IFolder;

import java.util.Date;

public class Folder extends Item implements IFolder {

    public Folder(String name){
        name.toLowerCase();
        this.itemName = name;
        this.createDate = null;
        this.modDate = null;
        this.location = null;
        this.creator = "";
    }

    @Override
    public String getItemName() {
        return itemName;
    }


    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;

    }

    @Override
    public Date getModDate() {
        return getModDate();
    }

    @Override
    public void setModDate(Date modDate) {
        this.modDate=modDate;

    }

    @Override
    public Path getLocation() {
        return location;
    }

    @Override
    public void setLocation(Path location) {
        this.location=location;

    }


    @Override
    public void setCreator(String creator) {
        this.creator=creator;
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
    public boolean isFile(){
        if (extension!=""){
            return true;
        }
        return false;
    }



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
}
