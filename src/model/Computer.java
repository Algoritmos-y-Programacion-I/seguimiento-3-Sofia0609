package model;
import java.util.ArrayList;  
import model.Incident;

public class Computer {

    String serialNumber;
    boolean nextWindow;
    ArrayList<Incident> incidents = ArrayList<Incident>;

    public Computer(String serialNumber, boolean nextWindow) {
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;
    }

    public String getSerialNumber() { 
        return serialNumber; 
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean getNextWindow() { 
        return nextWindow; 
    }

    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }

    public void addIncident(String descripcion, LocalDate dateReport) {
        Incident nIncident = new Incident(descripcion, dateReport);
        incidents.add(nIncident);     
    }
}
