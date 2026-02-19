package edu.touro.las.mcon364.taskmanager;
// I had AI help me come up with this ideas
public non-sealed class ClearAllTasksCommand implements Command {
    private final TaskRegistry registry;

    public ClearAllTasksCommand(TaskRegistry registry) {
        this.registry = registry;
    }

    public void execute() {
        registry.remove(registry.getAll().toString());
    }
}
