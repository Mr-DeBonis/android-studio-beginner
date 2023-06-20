import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarInterface carInterface = new ElectricCar("Tesla");
        carInterface.start();
        carInterface.move(60);

        CarInterface fossilCarInterface = new FossilFuelCar("Mercedes");
        fossilCarInterface.start();
        fossilCarInterface.move(100);


        ////////////////////////////
        TestAbstractClass testAbstractClass = new TestClass();
        testAbstractClass.printName("Meisam");
    }
}