package mameie.kfzService.db.obj;

public class DataBaseColumn {
    private String dataBasetype,dataBaseColumn,dataBaseResult;

    public DataBaseColumn(String dataBaseColumn, String dataBasetype){
        this.dataBaseColumn=dataBaseColumn;
        this.dataBasetype=dataBasetype;
    }

    public String getDataBasetype() {
        return dataBasetype;
    }

    public void setDataBasetype(String dataBasetype) {
        this.dataBasetype = dataBasetype;
    }

    public String getDataBaseColumn() {
        return dataBaseColumn;
    }

    public void setDataBaseColumn(String dataBaseColumn) {
        this.dataBaseColumn = dataBaseColumn;
    }

    public String getDataBaseResult() {
        return dataBaseResult;
    }

    public void setDataBaseResult(String dataBaseResult) {
        this.dataBaseResult = dataBaseResult;
    }
}
