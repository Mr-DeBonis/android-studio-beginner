public class Main {
    public static void main(String[] args) {
        // Static variables vcan be assigned like this
        TestClass.name = "Meisam";

        TestClass testClass = new TestClass(25, "White");

        // Or can be assigned like this
        testClass.setName("Meisam");

        System.out.println("Name: " + testClass.getName());

        TestClass secondTestClass = new TestClass(30, "Black");
        // Name is shared between both instances.
        System.out.println(secondTestClass.name);

        TestClass.printSomething();


    }
}