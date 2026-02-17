package edu.touro.las.mcon364.taskmanager;

import java.util.Optional;

public non-sealed class UpdateTaskCommand implements Command {
    private final TaskRegistry registry;
    private final String taskName;
    private final Priority newPriority;

    public UpdateTaskCommand(TaskRegistry registry, String taskName, Priority newPriority) {
        this.registry = registry;
        this.taskName = taskName;
        this.newPriority = newPriority;
    }

    public void execute() {
        // NOTE: This demonstrates old-style null checking
        // Students should refactor to use Optional and custom exceptions
        Optional<Task> existing = Optional.ofNullable(registry.get(taskName));
        Task task = existing
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found. Sorry")
                );

        // Create a new task with updated priority (tasks are immutable)
        Task updated = new Task(task.getName(), newPriority);
        registry.add(updated);  // This replaces the old task
    }
}
