import java.util.Scanner;

public class Rocket implements Spaceship{
    public int cost;
    public int rocketWeight;
    public int maxWeight;
    public float launchExplotionProb;
    public float landCrashProb;

    public Rocket() {}

    public Rocket(int cost, int rocketWeight, int maxWeight, float launchExplotionProb, float landCrashProb) {
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
        this.launchExplotionProb = launchExplotionProb;
        this.landCrashProb = landCrashProb;
    }


    @Override
    public Boolean launch() {
        return true;
    }

    @Override
    public Boolean land() {
        return true;
    }

    @Override
    public final void carry(Item item) {
        rocketWeight += item.getWeight();
    }

    @Override
    public final Boolean canCarry(Item item) {
        return ((rocketWeight + item.getWeight()) <= maxWeight);
    }
}
