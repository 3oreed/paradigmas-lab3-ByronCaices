package myfilesystem.models;

public interface IItem {
    String getItemName();
    void setItemName(String itemName);
    java.util.Date getCreateDate();
    void setCreateDate(java.util.Date createDate);
    java.util.Date getModDate();
    void setModDate(java.util.Date modDate);
    String getLocation();
    void setLocation(String location);
    String getCreator();
    void setCreator(String creator);
}

