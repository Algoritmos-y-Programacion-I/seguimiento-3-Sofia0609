package ui;

import java.util.Scanner;
import model.SchoolController;
import java.util.ArrayList;  

public class SchoolApp {

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para conectar esta clase con el
     * modelo.
     */

    private Scanner input;
    private SchoolController controller;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
        this.controller = new SchoolController("controller");
    }


    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    public void registrarComputador() {

        int ok = 1;
        boolean nextWindow = false;

        System.out.println("=== Registrar Computador ===");

        System.out.println("Por favor ingresa el numero de piso");
        int piso = input.nextInt();
        input.nextLine();

        System.out.println("Por favor ingresa el el numero de Serie del Computer");
        String serialNumber = input.nextLine();

        while (ok == 1){
            
            System.out.println("Por favor ingrese el next window (T/F)");
            String stringnextWindow = input.nextLine();

                if (stringnextWindow.equals("T")){
                    nextWindow = true;
                    ok = 0;
                }else if (stringnextWindow.equals("F")){
                    nextWindow = false;
                    ok = 0;
                }else{
                    System.out.println("Ingrese un valor Valido");
                }
            
        }

        
            String nComputer = controller.agregarComputador(piso, serialNumber, nextWindow);
            System.out.println(nComputer);
    }

    public void registrarIncidenteEnComputador() {

        System.out.println("===Registrar Incidentes en un Computador===");

        System.out.println("Por favor ingresa el el numero de Serie del Computer");
            String serialNumber = input.nextLine();

            System.out.println("Por favor ingrese la descripcion del incidente");
            String descripcion = input.nextLine();

            System.out.println("Por favor ingrese el año del incidente");
            int año = input.nextInt();
            input.nextLine();
            
            System.out.println("Por favor ingrese el mes del incidente");
            int mes = input.nextInt();
            input.nextLine();

            System.out.println("Por favor ingrese el dia del incidente");
            int dia = input.nextInt();
            input.nextLine();

            String nIncident = controller.agregarIncidenteEnComputador(serialNumber, descripcion, año, mes, dia);
            System.out.println(nIncident);

    }

    public void consultarComputadorConMasIncidentes() {

        System.out.println("===Computador con mas Incidentes===");
        String computadorMasIncidentes = controller.ComputadorconmasIncidentes();
        System.out.println("El computador con mas incidentes es: " + computadorMasIncidentes);

    }

}
