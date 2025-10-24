package model;

public class SchoolController {

    int[][] matrizComputers = new int[5][5];

    public SchoolController(int[][] matrizComputers) {
        this matrizComputers = matrizComputers;
    }

   
    public void agregarComputador(String serialNumber, boolean nextWindow) {

        for(int i = 0; i < matrizComputers.length; i++) {
            for(int j = 0; j < matrizComputers[0].length; j++) {

                Computer nComputer = new Computer(serialNumber, nextWindow)
                matrizComputers[i][j] = nComputer;
            }
        }

    }

    public void agregarIncidenteEnComputador(String serialNumber, String descripcion, LocalDate dateReport) {

        for(int i = 0; i < matrizComputers.length; i++) {
            for(int j = 0; j < matrizComputers[0].length; j++) {

                if (matrizComputers[i][j] != null){
                    if ( serialNumber.equals(matrizComputers[i][j].getSerialNumber())){
                        addIncident(descripcion, dateReport);
                    }
                }

            }
        }
    }

    public void getComputerList() {

    }

}
