package mvc.model;

import mvc.controller.SimulationManager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private boolean run = true;

    public Server(){
        this.tasks = new LinkedBlockingQueue<Task>();
        this.waitingPeriod = new AtomicInteger();
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void addTask(Task newTask){
        tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    public void run(){
        while(run){
            if(!tasks.isEmpty()) {
                Task auxTask;
                auxTask = tasks.peek();
                if (auxTask != null) {
                    try {
                        Thread.sleep(10000 * auxTask.getServiceTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //waitingPeriod.getAndAdd(-auxTask.getServiceTime());
                    //tasks.remove(auxTask);
                    //waitingPeriod.decrementAndGet();
                }
            }
            else run = false;
        }
    }
}
