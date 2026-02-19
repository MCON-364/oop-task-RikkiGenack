package edu.touro.las.mcon364.taskmanager;

public class TaskManager extends RuntimeException{

    private final TaskRegistry registry;

    public TaskManager(TaskRegistry registry) {
        this.registry = registry;
    }

    // TODO: Students must refactor this using pattern-matching switch
    // Current implementation uses old-style instanceof checks
    public void run(Command command) {
        switch (command) {
            case AddTaskCommand add -> command.execute();
            case RemoveTaskCommand remove -> command.execute();
            case UpdateTaskCommand update -> command.execute();
            case ClearAllTasksCommand clearAllTasksCommand -> command.execute();
            default -> throw new TaskNotFoundException("Unknown command type");
        }

    }
}
