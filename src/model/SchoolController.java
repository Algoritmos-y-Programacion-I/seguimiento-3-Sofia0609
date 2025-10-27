package model;
import java.util.ArrayList;
import java.time.LocalDate; 

public class SchoolController {

    private Computer[][] matrizComputers;
    public static final int FLOORS = 5;
    public static final int COL = 10;
    private String name;

    public SchoolController(String name) {
        this.name = name;
        this.matrizComputers = new Computer[FLOORS][COL];
    }
   
    
    /*Agregar Computador
    Descripcion: Este metodo permite registrar un computador en el Sistema
    *@param String serialNumber , es el codigo que identifica al computador
    *@param int piso , es el piso donde se ubica el computador
    *@param boolean nextWindow , es un atributo necesario para registrar el computador
    *@return String
    */
    public String agregarComputador(int piso, String serialNumber, boolean nextWindow) {

        if (piso < 1 || piso > FLOORS) {
        return "Error: El piso debe estar entre 1 y " + FLOORS;
        }

        int fila = piso - 1;

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COL; j++) {
                if (matrizComputers[i][j] != null && matrizComputers[i][j].getSerialNumber().equals(serialNumber)) {
                    return "Error: Ya existe un computador con ese numero de Serie";
                }
            }
        }

    for (int j = 0; j < COL; j++) {

            if (matrizComputers[fila][j] == null) {

                Computer nComputer = new Computer(serialNumber, nextWindow);
                matrizComputers[fila][j] = nComputer;
                
                return "Computador Registrado con Exito";
            }
        }

        return "Error: El piso está lleno.";
    }

    /*Registrar Incidente en un Computador
    *Descripcion: Este metodo permite registrar un incidente que le ocurrio a un computador
    *@param String serialNumber , es el codigo que identifica al computador
    *@param String descripcion , es la descripcion del incidente ocurrido
    *@param int año , es el año en el que ocurrio el incidente
    *@param int mes , es el mes en el que ocurrio el incidente
    *@param int dia , es el dia en el que ocurrio el incidente
    *@return String
    */

    public String agregarIncidenteEnComputador(String serialNumber, String descripcion, int año, int mes, int dia) {
        
        LocalDate dateReport = LocalDate.of(año, mes, dia);

        for(int i = 0; i < matrizComputers.length; i++) {
            for(int j = 0; j < matrizComputers[0].length; j++) {

                if (matrizComputers[i][j] != null){
                    if (serialNumber.equals(matrizComputers[i][j].getSerialNumber())){
                        matrizComputers[i][j].addIncident(descripcion, dateReport);
                        return "Incidente Reportado con Exito";
                    }
                }

            }
        }
        return "Error: Computador no encontrado";
    }

    /*Computador con mas Incidentes
    Descripcion: Este metodo muestra al usuario el Serial Number del computador con mas incidentes y su ubicacion
    *@return String
    */

    public String ComputadorconmasIncidentes(){

        String mensaje = "";
        String computerMayor = null;
        int fila = 0;
        int columna = 0;
        int numeroIncidents = -1;

        for(int i = 0; i < matrizComputers.length; i++) {
            for(int j = 0; j < matrizComputers[0].length; j++) {

                if(matrizComputers[i][j] != null){

                    ArrayList<Incident> incidentsComputer = matrizComputers[i][j].getIncidents();

                    if (incidentsComputer.size() > numeroIncidents ){

                        numeroIncidents = incidentsComputer.size();
                        computerMayor = matrizComputers[i][j].getSerialNumber();
                        fila = i + 1;
                        columna = j + 1;
                        
                    }
                }
            }                            
        }

        if (computerMayor == null){
            mensaje = "Ninguno, No hay computadores registrados";
        }else{
            mensaje = "\n" +
                    "Numero Serial: " + computerMayor + "\n" +
                    "piso: " + fila + "\n" +
                    "columna: " + columna;
        }
        return mensaje;                                                      
    }

    public Computer[][] getMatrizComputer() {
        return matrizComputers; 
    }

}
