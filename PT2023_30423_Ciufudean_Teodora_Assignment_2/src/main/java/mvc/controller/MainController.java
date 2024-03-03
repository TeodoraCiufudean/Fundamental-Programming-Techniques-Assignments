package mvc.controller;

import mvc.view.SimulationFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private SimulationFrame simulationFrame;

    public MainController(SimulationFrame simulationFrame){
        this.simulationFrame = simulationFrame;
        this.simulationFrame.addStartListener(new StartListener());
    }

    class StartListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int clientsNumber = 0;
            int serversNumber = 0;
            int simulationTime = 0;
            int maxArrivalTime = 0;
            int minArrivalTime = 0;
            int maxServiceTime = 0;
            int minServiceTime = 0;
            String policy = null;
            SelectionPolicy selectionPolicy;
            try {
                clientsNumber = simulationFrame.getClientsTextField();
                serversNumber = simulationFrame.getQueuesTextField();
                simulationTime = simulationFrame.getSimulationTextField();
                maxArrivalTime = simulationFrame.getMaxArrivalTextField();
                minArrivalTime = simulationFrame.getMinArrivalTextField();
                maxServiceTime = simulationFrame.getMaxServiceTextField();
                minServiceTime = simulationFrame.getMinServiceTextField();
                policy = (String) simulationFrame.getComboBox().getSelectedItem();
                if (policy.equals("SHORTEST_TIME"))
                {
                    selectionPolicy = SelectionPolicy.SHORTEST_TIME;
                }
                else selectionPolicy = SelectionPolicy.SHORTEST_QUEUE;
                SimulationManager simulationManager = new SimulationManager(clientsNumber,serversNumber,simulationTime,maxArrivalTime,minArrivalTime,maxServiceTime,minServiceTime,selectionPolicy);
                Thread t = new Thread(simulationManager);
                t.start();
            } catch (Exception exception){
                simulationFrame.showErrorMessage("Bad input.");
                exception.printStackTrace();
            }
        }
    }
}
