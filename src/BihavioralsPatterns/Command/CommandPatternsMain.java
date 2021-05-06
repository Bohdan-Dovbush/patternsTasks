package BihavioralsPatterns.Command;

import BihavioralsPatterns.Command.Databesed.*;

public class CommandPatternsMain {
    public static void main(String[] args) {
        Databased databased = new Databased();

        Developer developer = new Developer(
                new InsertCommand(databased),
                new UpdateCommand(databased),
                new SelectCommand(databased),
                new DeleteCommand(databased)
        );

        developer.insertRecord();
        developer.updateRecord();
        developer.selectRecord();
        developer.deleteRecord();
    }
}
