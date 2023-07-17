package myfilesystem.models;

import myfilesystem.interfaces.IFile;

import java.util.Date;

public class File extends Item implements IFile {
    //String extension;
    //String text;

    public File(String name, FileSystem fl){
        name.toLowerCase();
        this.itemName = name;
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = new Path(fl.getCurrentPath().pathToString()+itemName);
        this.creator = fl.getLogedUser().getUserName();
        this.extension = getExtFromName(name);
        this.text = "";
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

    public File() {
        super();
    }

    public String getExtension() {
        return extension;
    }

    public String getText() {
        return text;
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
    public Path getLocation() {
        return super.getLocation();
    }

    @Override
    public void setLocation(Path location) {
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
    public boolean isFile(){
        if (extension!=""){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "File{" +
                "extension='" + extension + '\'' +
                ", text='" + text + '\'' +
                ", itemName='" + itemName + '\'' +
                ", location='" + location + '\'' +
                ", creator=" + creator +
                '}';
    }
}
