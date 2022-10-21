public class Animal {

    private String type;
    private String size;
    private int weight;

    public Animal(String type, String size, int weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public boolean esPesado(){
        return this.size == "grande" && this.weight > 100;
    }
}
