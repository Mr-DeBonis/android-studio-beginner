public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("Renault", 8000);
        Car mercedes = new Car("Mercedes AMG", 2, "Silver", engine);
        System.out.println(mercedes.getName());

        System.out.println("Engine Model: " + mercedes.getEngine().getModel());
    }
}