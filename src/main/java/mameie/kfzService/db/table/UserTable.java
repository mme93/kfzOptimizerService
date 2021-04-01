package mameie.kfzService.db.table;

import mameie.kfzService.db.method.KfzOptimzerDataBase;
import mameie.kfzService.db.obj.DataBaseColumn;
import mameie.kfzService.db.settings.ReadOnlyDataBaseFunction;

import java.util.ArrayList;
import java.util.List;

public class UserTable implements ReadOnlyDataBaseFunction {
    //Table Name
    public final static String tableName = "Benutzer";
    //Columns
    public final static String str_vorname = "Vorname";
    public final static String str_nachename = "Nachname";
    public final static String str_email = "Email";
    public final static String str_passwort = "Passwort";
    //List with Column Names
    List<String> columnList = new ArrayList<>();
    private List<List<DataBaseColumn>> tableList;

    public UserTable() {
        initColumnList();
    }

    public boolean checkLogin(String email,String passwort){
        boolean isEmail=false,isPassword=false;
        if(tableList==null ||tableList.size()==0){
            return false;
        }
        for(List<DataBaseColumn>list:tableList){
            for(DataBaseColumn column:list){
                if(column.getDataBaseColumn().equals(str_email)&&column.getDataBaseResult().equals(email)){
                    isEmail=true;
                }else if(column.getDataBaseColumn().equals(str_passwort)&&column.getDataBaseResult().equals(passwort)){
                    isPassword=true;
                }
            }
        }
        return (isEmail&&isPassword);
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
        this.columnList.add("str_" + str_vorname);
        this.columnList.add("str_" + str_nachename);
        this.columnList.add("str_" + str_email);
        this.columnList.add("str_" + str_passwort);
    }
}

