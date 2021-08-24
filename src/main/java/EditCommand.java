public class EditCommand extends Command {
    private EditType editType;
    private int taskIndex;

    public EditCommand(EditType editType, int taskIndex) {
        this.editType = editType;
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            Task editedTask;
            switch (this.editType) {
            case DONE:
                editedTask = taskList.markAsDone(this.taskIndex);
                break;
            case DELETE:
                editedTask = taskList.delete(this.taskIndex);
                break;
            default:
                throw new DukeException("Unknown command.");
            }
            storage.overwriteSave(taskList);
            ui.updateUserOnEditedTask(editedTask, taskList.getNumberOfTasks(), this.editType);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please enter a valid task number.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
