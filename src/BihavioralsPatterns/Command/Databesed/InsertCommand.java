package BihavioralsPatterns.Command.Databesed;

import BihavioralsPatterns.Command.Command;

public class InsertCommand implements Command {

    final Databased databased;

    public InsertCommand(Databased databased) {
        this.databased = databased;
    }

    @Override
    public void execute() {
        databased.insert();
    }
}
