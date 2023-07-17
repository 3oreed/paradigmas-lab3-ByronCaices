package myfilesystem.models;

import myfilesystem.interfaces.IFile;

import java.util.Date;

public class File extends Item implements IFile {


    public File(String name, FileSystem fl){
        name.toLowerCase();
        this.itemName = name.toLowerCase();
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = new Path(fl.getCurrentPath().pathToString()+itemName);
        this.creator = fl.getLogedUser().getUserName();
        this.extension = getExtFromName(name);
        this.text = "";
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


    public String getExtFromName(String filename) {

        String extension = "";

        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex >= 0) {
            extension = filename.substring(dotIndex + 1);
        }
        return  extension;
        //System.out.println("La extensión del archivo es: " + extension);
    }



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
}
