package mvc.model;

public class Task implements Comparable<Task>{
    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Task(int ID, int arrivalTime,int serviceTime){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        String finalString;
        finalString = "("+ ID + "," + arrivalTime + "," + serviceTime + ")";
        return finalString;
    }

    @Override
    public int compareTo(Task o) {
        if(o.arrivalTime < this.arrivalTime) return 1;
        else if (o.arrivalTime > this.arrivalTime) return -1;
        else return 0;
    }
}
