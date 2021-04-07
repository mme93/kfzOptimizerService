package mameie.kfzService.db.table;

import mameie.kfzService.db.method.KfzOptimzerDataBase;
import mameie.kfzService.db.obj.DataBaseColumn;
import mameie.kfzService.db.settings.ReadOnlyDataBaseFunction;

import java.util.ArrayList;
import java.util.List;

public class ServiceTable implements ReadOnlyDataBaseFunction {

    //Table Name
    public final static String tableName = "Service";
    //Columns
    public final static String str_name = "Name";
    public final static String int_intervall = "Intervall";
    public final static String int_kosten = "Kosten";
    //List with Column Names
    List<String> columnList = new ArrayList<>();
    private List<List<DataBaseColumn>> tableList;

    public ServiceTable() {
        initColumnList();
    }

    public List<List<DataBaseColumn>> getServiceList(){
      return tableList;
    }


    @Override
    public boolean load() {
        this.tableList = KfzOptimzerDataBase.loadTableFromDataBase(this.tableName, this.columnList);
        if (this.tableList == null || this.tableList.size() == 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean reset() {
        this.tableList.clear();
        if (this.tableList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void initColumnList() {
        this.columnList.add("str_" + str_name);
        this.columnList.add("int_" + int_intervall);
        this.columnList.add("int_" + int_kosten);
    }
}
