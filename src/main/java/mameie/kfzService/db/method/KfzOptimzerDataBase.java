package mameie.kfzService.db.method;

import mameie.kfzService.db.obj.DataBaseColumn;
import mameie.kfzService.db.settings.DataBaseSettings;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KfzOptimzerDataBase {
    private static String trimTyp(String columName){
        String[] splitColumnName=columName.split("_");
        return splitColumnName[0];
    }
    private static String trimColumn(String columName){
        String[] splitColumnName=columName.split("_");
        return splitColumnName[1];
    }
    public static List<List<DataBaseColumn>> loadTableFromDataBase(String tableName, List<String> columnName) {
        List<List<DataBaseColumn>>tableList= new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DataBaseSettings.connectionString);
            Statement stmt = null;
            ResultSet result = null;
            String querry = "SELECT * FROM " + tableName;
            try {
                if (!con.isClosed()) {
                    stmt = con.createStatement();
                    if (stmt.execute(querry)) {
                        result = stmt.getResultSet();
                        while (result.next()) {
                            List<DataBaseColumn> resultList = new ArrayList<>();
                            for (String column : columnName) {
                                //Datein Typ in der Datenbank
                                //!!!GANNZ WICHTIG DAS DIE COLUMN typ_ColumnName ist!!!!
                                if(trimTyp(column).equals("str")){
                                    DataBaseColumn resultColum = new DataBaseColumn(trimColumn(column), trimTyp(column));
                                    resultColum.setDataBaseResult(result.getString(trimColumn(column)));
                                    resultList.add(resultColum);
                                }
                            }
                            tableList.add(resultList);
                        }
                        return tableList;
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tableList;
    }
}




