package mvc.controller;

import mvc.model.Server;
import mvc.model.Task;

import java.util.List;

public interface Strategy {
    public void addTask(List<Server> servers, Task t);
}
