package edu.touro.las.mcon364.taskmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRegistry {
    private final Map<String, Task> tasks = new HashMap<>();

    public void add(Task task) {
        tasks.put(task.getName(), task);
    }

    public Task get(String name) {
        return tasks.get(name);
    }

    public void remove(String name) {
        tasks.remove(name);
    }

    public Map<String, Task> getAll() {
        return tasks;
    }

    public Map<Priority, List<Task>> getTasksByPriority() {
        Map<Priority, List<Task>> tasksByPriority = new HashMap<>();
        List<Task> h = new ArrayList<Task>();
        List<Task> m = new ArrayList<Task>();
        List<Task> l = new ArrayList<Task>();
        if(tasks.isEmpty())
            return null;
        for(Task t: tasks.values()){
          Priority priority = t.getPriority();
          switch(priority){
              case Priority.HIGH:
                  h.add(t);
                break;
              case Priority.MEDIUM:
                  m.add(t);
                 break;
              case Priority.LOW:
                  l.add(t);
                  break;
          }
       }
        tasksByPriority.put(Priority.HIGH, h);
        tasksByPriority.put(Priority.MEDIUM, m);
        tasksByPriority.put(Priority.LOW, l);
        return tasksByPriority;
    }
}
