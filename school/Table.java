package school;

public class Table {
    private String color;
    private String shape;
    private int num_legs;

    public Table() {
    }

    public Table(String c, String sh, int nl) {
        this.color = c;
        this.shape = sh;
        this.num_legs = nl;
    }

    public Table(Table t1) {
        this.color = t1.color;
        this.shape = t1.shape;
        this.num_legs = t1.num_legs;
    }

    public String getColor() {
        return this.color;
    }

    public String getShape() {
        return this.shape;
    }

    public int getNumLegs() {
        return this.num_legs;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public String toString() {
        return "the color is: " + this.color + "the shape is: " + this.shape + "the num of legs is: " + this.num_legs;
    }

}