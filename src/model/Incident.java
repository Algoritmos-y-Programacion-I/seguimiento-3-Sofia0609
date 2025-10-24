package model;
import java.time.LocalDate; 
 
public class Incident{
    
    private String descripcion;
    private LocalDate dateReport;
    private boolean solution;
    private int solutionHour;

    public Incident(String descripcion, LocalDate dateReport) {
        this.descripcion = descripcion;
        this dateReport = dateReport;s
    }

    public String getDescripcion() { 
        return descripcion; 
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDateReport() { 
        return dateReport; 
    }

    public void setDateReport(LocalDate dateReport) {
        this dateReport = dateReport;
    }

    public String getSolution() { 
        return solution; 
    }

    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    public String getSolutionHour() { 
        return solutionHour; 
    }

    public void setSolution(int solutionHour) {
        this.solutionHour = solutionHour;
    }

}
    



