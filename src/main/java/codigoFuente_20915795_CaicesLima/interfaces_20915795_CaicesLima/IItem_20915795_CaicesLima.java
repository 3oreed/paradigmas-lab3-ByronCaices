package codigoFuente_20915795_CaicesLima.interfaces_20915795_CaicesLima;

import java.util.Date;

import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.Item_20915795_CaicesLima;
import codigoFuente_20915795_CaicesLima.models_20915795_CaicesLima.Path_20915795_CaicesLima;

public interface IItem_20915795_CaicesLima {

    String getItemName();
    void setCreateDate(Date createDate);
    Date getModDate();
    void setModDate(Date modDate);
    Path_20915795_CaicesLima getLocation();
    void setLocation(Path_20915795_CaicesLima location);
    void setCreator(String creator);
    String getExtension();
    void setExtension(String extension);
    String getText();
    void setText(String text);
    boolean isFile();
    Item_20915795_CaicesLima itemClone();
}
