import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File inpPhase1File = new File("phase1.txt");
        File inpPhase2File = new File("phase2.txt");
        Simulation u1Simulation = new Simulation();
        Simulation u2Simulation = new Simulation();


        int u1Cost = u1Simulation.runSimulation(u1Simulation.loadU1(u1Simulation.loadItems(inpPhase1File)));
        u1Cost += u1Simulation.runSimulation(u1Simulation.loadU1(u1Simulation.loadItems(inpPhase2File)));


        int u2Cost = u2Simulation.runSimulation(u2Simulation.loadU1(u2Simulation.loadItems(inpPhase1File)));
        u2Cost += u2Simulation.runSimulation(u2Simulation.loadU1(u2Simulation.loadItems(inpPhase2File)));

        System.out.println("Costs for U1 rockets : "+u1Cost);
        System.out.println("Costs for U2 rockets : "+u2Cost);
    }
}