
package myfilesystem.interfaces;

import myfilesystem.models.Path;

import java.util.Date;

public interface IItem {
    String getItemName();
    void setItemName(String itemName);
    Date getCreateDate();
    void setCreateDate(java.util.Date createDate);
    Date getModDate();
    void setModDate(java.util.Date modDate);
    Path getLocation();
    void setLocation(Path location);
    String getCreator();
    void setCreator(String creator);
}

