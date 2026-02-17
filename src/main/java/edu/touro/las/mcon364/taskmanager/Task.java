package edu.touro.las.mcon364.taskmanager;

import java.util.Objects;

public record Task(String name, Priority priority) {


    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }


}
