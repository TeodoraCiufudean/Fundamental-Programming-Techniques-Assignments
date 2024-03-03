package mvc.controller;

import mvc.model.Task;
import mvc.view.SimulationFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationManager implements Runnable {
    private Scheduler scheduler;
    private SimulationFrame frame= new SimulationFrame();
    private List<Task> generatedTasks;
    private int clientsNumber ;
    private int serversNumber ;
    private int simulationTime ;
    private int maxArrivalTime ;
    private int minArrivalTime ;
    private int maxServiceTime;
    private int minServiceTime;
    private double averageServiceTime = 0.0;
    private double averageWaitingTime = 0.0;
    private int totalServiceTime = 0;
    private int totalWaitingTime = 0;
    private SelectionPolicy policy;
    boolean start = false;
    int max = 0;
    int peakHour = 0;

    public SimulationManager(int clientsNumber, int serversNumber, int simulationTime, int maxArrivalTime,int minArrivalTime, int maxServiceTime, int minServiceTime, SelectionPolicy policy) {
        this.clientsNumber = clientsNumber;
        this.serversNumber = serversNumber;
        this.simulationTime = simulationTime;
        this.maxArrivalTime = maxArrivalTime;
        this.minArrivalTime =minArrivalTime;
        this.maxServiceTime = maxServiceTime;
        this.minServiceTime =minServiceTime;
        this.policy = policy;
        scheduler = new Scheduler(serversNumber, clientsNumber, policy);
        generatedTasks = new ArrayList<Task>();
        scheduler.changeStrategy(policy);
        generateNRandomTasks();
    }

    public void generateNRandomTasks() {
        Random randomGenerator = new Random();
        for (int i = 0; i < clientsNumber; i++) {
            int randomServiceTime = randomGenerator.nextInt(maxServiceTime) + minServiceTime;
            int randomArrivalTime = randomGenerator.nextInt(maxArrivalTime) + minArrivalTime;
            Task newTask = new Task(i, randomArrivalTime, randomServiceTime);
            generatedTasks.add(newTask);
            totalServiceTime += randomServiceTime;
        }
        Collections.sort(generatedTasks);
    }

    @Override
    public void run() {
            int currentTime = 0;
            String output="";
            try {
                FileWriter fileWriter = new FileWriter("log.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(generatedTasks.toString() + "\n");

                //int tasksPerHour = 0;
                //int max = 0;
                //int peakHour = 0;
                while (currentTime < simulationTime) {
                    output ="";
                    int tasksPerHour = 0;
                    totalWaitingTime = 0;
                    printWriter.print("Time: " + currentTime + "\n");
                    output = "Time: " + currentTime + "\n";
                    //frame.getTextArea().append("Time: " + currentTime + "\n");
                    for (int i = 0; i < scheduler.getServers().size(); i++) {
                        int newServiceTime;
                        if (scheduler.getServers().get(i).getTasks().peek() != null) {
                            newServiceTime = scheduler.getServers().get(i).getTasks().peek().getServiceTime();
                            if (newServiceTime == 1) {
                                AtomicInteger wp = scheduler.getServers().get(i).getWaitingPeriod();
                                wp.addAndGet(-newServiceTime);
                                scheduler.getServers().get(i).setWaitingPeriod(wp);
                                scheduler.getServers().get(i).getTasks().remove();

                            } else {
                                scheduler.getServers().get(i).getTasks().peek().setServiceTime(newServiceTime - 1);
                            }
                        }
                    }
                    for (int i = 0; i < generatedTasks.size(); i++) {
                        if (currentTime == generatedTasks.get(i).getArrivalTime()) {
                            scheduler.dispatchTask(generatedTasks.get(i));
                            generatedTasks.remove(i--);
                        }
                    }

                    printWriter.print("Waiting clients: " + generatedTasks.toString() + "\n");
                    //frame.getTextArea().append("Waiting clients: " + generatedTasks.toString() + "\n");
                    output = output + "Waiting clients: " + generatedTasks.toString() + "\n";
                    for (int i = 0; i < scheduler.getServers().size(); i++) {
                        printWriter.print("Queue: " + (i + 1) + ": ");
                        printWriter.print(scheduler.getServers().get(i).getTasks().toString() + "\n");
                        //frame.getTextArea().append("Queue: " + (i + 1) + ": ");
                        //frame.getTextArea().append(scheduler.getServers().get(i).getTasks().toString() + "\n");
                        output = output + "Queue: " + (i + 1) + ": ";
                        output = output + scheduler.getServers().get(i).getTasks().toString() + "\n";


                    }
                    for (int i = 0; i < scheduler.getServers().size(); i++) {
                        //printWriter.print("Queue: " + (i + 1) + ": ");
                        //printWriter.print(scheduler.getServers().get(i).getTasks().toString() + "\n");
                        //frame.getTextArea().append("Queue: " + i + 1 + ": ");
                        //frame.getTextArea().append(scheduler.getServers().get(i).getTasks().toString() + "\n");
                        tasksPerHour += scheduler.getServers().get(i).getTasks().size();
                        totalWaitingTime += scheduler.getServers().get(i).getWaitingPeriod().intValue();
                    }
                    if (tasksPerHour > max) {
                        max = tasksPerHour;
                        peakHour = currentTime;
                    }
                    printWriter.print("\n");
                    currentTime++;
                    Thread.sleep(1500);
                    frame.getTextArea().setText(output);
                }
                averageServiceTime = ((double)totalServiceTime / clientsNumber);
                averageWaitingTime = ((double)totalServiceTime / (clientsNumber * serversNumber));
                printWriter.write("Average waiting time: " + averageWaitingTime + "\n");
                printWriter.write("Average service time: " + averageServiceTime + "\n");
                printWriter.write("Peak hour: " + peakHour);
                output = output + "Average waiting time: " + averageWaitingTime + "\n" + "Average service time: " + averageServiceTime + "\n" + "Peak hour: " + peakHour;
                frame.getTextArea().setText(output);
                // frame.getTextArea().append("Average waiting time: " + averageWaitingTime + "\n");
                // frame.getTextArea().append("Average service time: " + averageServiceTime + "\n");
                // frame.getTextArea().append("Peak hour: " + peakHour);

                fileWriter.close();
                printWriter.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        SimulationFrame simulationFrame = new SimulationFrame();
        MainController mainController = new MainController(simulationFrame);
    }
}
