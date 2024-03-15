public class U2 extends Rocket{
    public U2(){
        super(120, 18000, 29000, 4.0f, 8.0f);
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
