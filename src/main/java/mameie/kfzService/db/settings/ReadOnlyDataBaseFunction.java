package mameie.kfzService.db.settings;

public interface ReadOnlyDataBaseFunction {

    public boolean load();
    public boolean reset();
    public void initColumnList();
}
