package ch06;

import java.io.Serial;
import java.io.Serializable;

public class Task implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String description;
    public Task(String description) { this.description = description; }
    public String getDescription() { return description; }
    @Override
    public String toString() { return description; }
}
