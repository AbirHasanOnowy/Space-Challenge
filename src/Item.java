public class Item {
    private String name;
    private int weight;

    Item(){}
    Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public final int getWeight() {
        return weight;
    }
}
