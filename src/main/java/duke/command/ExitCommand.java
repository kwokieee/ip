package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * The ExitCommand class encapsulates the instructions needed to exit Duke.
 */
public class ExitCommand extends Command {
    /**
     * Executes the instructions for exiting Duke.
     * 
     * @param taskList Task list of the user loaded on Duke.
     * @param ui The object representing Duke's UI.
     * @param storage The object representing Duke's data and storage.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.stop();
    }

    /**
     * Checks whether the command exits Duke.
     * 
     * @return true.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /**
     * Checks whether another object is equal with this exit command.
     * 
     * @param other The object being compared to.
     * @return true if both are exit commands, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof ExitCommand;
    }
}
