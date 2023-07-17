package myfilesystem.interfaces;

import java.util.Date;
import myfilesystem.models.Path;

public interface IItem {

    String getItemName();

    void setCreateDate(Date createDate);

    Date getModDate();

    void setModDate(Date modDate);

    Path getLocation();

    void setLocation(Path location);


    void setCreator(String creator);

    String getExtension();

    void setExtension(String extension);

    String getText();

    void setText(String text);

    boolean isFile();
}
