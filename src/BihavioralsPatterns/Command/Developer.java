package BihavioralsPatterns.Command;

public class Developer {
    final Command insert;
    final Command delete;
    final Command update;
    final Command select;

    public Developer(Command insert, Command delete, Command update, Command select) {
        this.insert = insert;
        this.delete = delete;
        this.update = update;
        this.select = select;
    }

    public void insertRecord(){
        insert.execute();
    }

    public void deleteRecord(){
        delete.execute();
    }

    public void selectRecord(){
        select.execute();
    }

    public void updateRecord(){
        update.execute();
    }
}
