package myfilesystem.models;

public class File extends Item {
    String extension;
    String text;

    public File(String name, FileSystem fl){
        this.itemName = name;
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = fl.getCurrentPath();
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

    @Override
    public String toString() {
        return "File{" +
                "extension='" + extension + '\'' +
                ", text='" + text + '\'' +
                ", itemName='" + itemName + '\'' +
                ", createDate=" + createDate +
                ", modDate=" + modDate +
                ", location='" + location + '\'' +
                ", creator=" + creator +
                '}';
    }
}
