package mvc.controller;

import mvc.model.Server;
import mvc.model.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
        int minVal = 9999;
        int position=0;
        for (int i = 0; i < servers.size(); i++){
            if(servers.get(i).getTasks().size() < minVal){
                minVal = servers.get(i).getTasks().size();
                position = i;
            }
        }
        servers.get(position).addTask(t);
    }
}
