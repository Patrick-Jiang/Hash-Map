package hashMap;

public class Item implements Comparable<Item> {
    private String name;
    private int value;
    private double weight;


    public Item(String name, int value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }


    public int getGoldPieces() {
        return value;
    }


    public double getWeight() {
        return weight;
    }


    public int compareTo(Item otherItem) {
        return this.name.compareTo(otherItem.getName());
    }


    public String toString() {
        String weightString = generateWeightString();
        return name + " is worth " + value + "gp and weighs " + weightString + "kg";
    }


    public boolean equals(Object obj) {

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Item item = (Item)obj;

        if (this.name.equals(item.getName()) &&
                this.value == item.getGoldPieces() && this.weight == item.getWeight()) {
            return true;
        }
        else {
            return false;
        }
    }


    private String generateWeightString() {
        if (weight % 1 != 0) {
            return String.format("%s", weight);
        }
        else {
            return String.format("%.0f", weight);
        }
    }
}
