package mameie.kfzService.db.settings;

import mameie.kfzService.db.obj.DataBaseColumn;

import java.util.List;

public interface DataBaseFunction {

    public boolean addRow();
    public boolean deleteRow();
    public boolean load();
    public boolean reset();
    public String getDBJsonString();
    public void initColumnList();
}
