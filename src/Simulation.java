import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public Simulation() {
    }

    public ArrayList<Item> loadItems(File inpTxtFile) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            Scanner input = new Scanner(inpTxtFile);
            while (input.hasNext()) {
                String[] data;
                data = input.nextLine().split("=");
                Item newItem = new Item(data[0],Integer.parseInt(data[1]));
                items.add(newItem);
            }
        } catch (FileNotFoundException exp) {
            System.out.println("Items input file not found");
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        U1 rocket = new U1();
        int itemCount = items.size();
        for(int i=0; i<itemCount; i++) {
            if(rocket.canCarry(items.get(i)))
                rocket.carry(items.get(i));
            else{
                i--;
                u1Rockets.add(rocket);
                rocket = new U1();
            }
        }
        if(rocket.rocketWeight > 10000)
            u1Rockets.add(rocket);
        return u1Rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        U2 rocket = new U2();
        int itemCount = items.size();
        for(int i=0; i<itemCount; i++) {
            if(rocket.canCarry(items.get(i)))
                rocket.carry(items.get(i));
            else{
                i--;
                u2Rockets.add(rocket);
                rocket = new U2();
            }
        }
        if(rocket.rocketWeight > 18000)
            u2Rockets.add(rocket);
        return u2Rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int budget = 0;
        int rocketCount = rockets.size();
        for(int i=0; i<rocketCount; i++) {
            budget += rockets.get(i).cost;
            if(!(rockets.get(i).launch() && rockets.get(i).land()))
                i--;
        }
        return budget;
    }
}
