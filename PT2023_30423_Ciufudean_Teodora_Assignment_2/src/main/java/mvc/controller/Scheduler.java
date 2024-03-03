package mvc.controller;

import mvc.model.Server;
import mvc.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int MaxTasksPerServer;
    private Strategy strategy;
    private SelectionPolicy policy;

    public Scheduler(int maxNoServers, int maxTasksPerServer, SelectionPolicy policy){
        this.MaxTasksPerServer = maxTasksPerServer;
        this.servers = new ArrayList<Server>();
        this.policy = policy;
        changeStrategy(policy);
        for (int i=0;i<maxNoServers;i++)
        {
            Server newServer = new Server();
            servers.add(newServer);
            Thread newThread = new Thread(newServer);
        }
    }

    public void changeStrategy (SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }

    public void dispatchTask(Task task){
        strategy.addTask(servers,task);
    }

    public List<Server> getServers(){
        return servers;
    }

}
