package org.example;

import java.util.Date;

public abstract class Item {

    String itemName;
    Date createDate;
    Date modDate;
    String location;
    User creator;
    //String extension;


    public Item() {}


    /*
    public Item(String name, FileSystem fl){
        this.itemName = name;
        this.createDate = fl.getSystemDate();
        this.modDate = fl.getSystemDate();
        this.location = fl.getCurrentPath();
        this.creator = fl.getLogedUser();
        //this.extension
    }
 */
}
