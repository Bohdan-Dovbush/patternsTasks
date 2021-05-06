package BihavioralsPatterns.Command.Databesed;

import BihavioralsPatterns.Command.Command;

public class UpdateCommand implements Command {

    final Databased databased;

    public UpdateCommand(Databased databased) {
        this.databased = databased;
    }

    @Override
    public void execute() {
        databased.update();
    }
}
