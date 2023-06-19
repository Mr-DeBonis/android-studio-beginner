public class TestClass {
    public static String name;
    public int age;
    public String skinColor;

    public TestClass(int age, String skinColor) {
        this.age = age;
        this.skinColor = skinColor;
    }

    public static void printSomething() {
        System.out.println("Printing...");
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        TestClass.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     * Inner class from TestClass
     */
    private class TestInnerClass {
        private String name;

        public TestInnerClass(String name) {
            this.name = name;
        }

        private void printAge() {
            // Can access parent attributes
            System.out.println("Age: " + age);
        }
    }

    /**
     * An inner class could be static
     */
    private static class TestInnerClass2 {
        private String name;

        public TestInnerClass2(String name) {
            this.name = name;
        }

        private void printAge() {
            // Can't access parent attributes if they're not static
            System.out.println("Age: " + age);
        }
    }
}
