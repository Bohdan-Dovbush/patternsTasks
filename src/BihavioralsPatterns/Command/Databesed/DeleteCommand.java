package BihavioralsPatterns.Command.Databesed;

import BihavioralsPatterns.Command.Command;

public class DeleteCommand implements Command {

    final Databased databased;

    public DeleteCommand(Databased databased) {
        this.databased = databased;
    }

    @Override
    public void execute() {
        databased.delete();
    }
}
