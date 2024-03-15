public class U1 extends Rocket {
    public U1(){
        super(100, 10000, 18000, 5.0f, 1.0f);
    }

    @Override
    public Boolean land() {
        return (landCrashProb * rocketWeight / maxWeight) <=  (Math.random() * 10);
    }

    @Override
    public Boolean launch() {
        return (launchExplotionProb * rocketWeight / maxWeight) <=  (Math.random() * 10);
    }
}
