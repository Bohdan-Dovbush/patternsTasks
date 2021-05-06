package BihavioralsPatterns.Command.Databesed;

import BihavioralsPatterns.Command.Command;

public class SelectCommand implements Command {

    final Databased databased;

    public SelectCommand(Databased databased) {
        this.databased = databased;
    }

    @Override
    public void execute() {
        databased.select();
    }
}
