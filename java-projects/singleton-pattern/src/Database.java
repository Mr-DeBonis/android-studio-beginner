public class Database {
    private String name;

    private static Database instance;

    public static Database getInstance(String name) {
        if (null == instance) {
            instance = new Database(name);
            return instance;
        }

        return instance;
    }

    // Change constructor to private to make it singleton
    private Database(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * What to print when calling println()
     *
     * @return class name
     */

    @Override
    public String toString() {
        String text = "Database class\n" +
                "Name: " + this.name;
        return text;
    }
}
