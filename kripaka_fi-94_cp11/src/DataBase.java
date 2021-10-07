public class DataBase {
    public DataBase() {
        System.out.println("Database created");
    }

    public void init() {
        System.out.println("Database initialized");
    }

    public void create(String tableName, int columns) {
        System.out.println("CREATED table " + tableName + " with " + columns + " columns");
    }

    public void insert(String tableName, int[] point) {
        System.out.println("Point " + point + " has been added to " + tableName);
    }

    public boolean contains(String tableName, int[] point) {

        return true;
    }

    public void search(String name, String[] searchQuery) {
        System.out.println("print elements");
    }
}
