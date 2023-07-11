package org.example;

public class File extends Item {
    String extension;

    public File(String name, FileSystem fl){
        this.itemName = name;
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = fl.getCurrentPath();
        this.creator = fl.getLogedUser();
        this.extension = getExtFromName(name);
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

}
