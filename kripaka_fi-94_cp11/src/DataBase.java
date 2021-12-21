import java.util.HashMap;

public class DataBase {

    private HashMap<String, KDTree> treeMap;

    public DataBase() {
        treeMap = new HashMap<>();
        System.out.println("Database created");
    }

    public boolean create(String dbName) {
        System.out.println("CREATED table " + dbName + " with " + " columns");
        treeMap.put(dbName, new KDTree());
        return true;
    }

    public boolean insert(String dbName, int[] point) {
        System.out.println("Point2d " + point + " has been added to " + dbName);
        if(!treeMap.isEmpty() && treeMap.containsKey(dbName)){
            treeMap.get(dbName).add(new Point2d(point[0], point[1]));
            return true;
        }
        return false;
    }

    public boolean contains(String dbName, int[] point) {
        System.out.println("contains");
        if(!treeMap.isEmpty() && treeMap.containsKey(dbName)) {
            treeMap.get(dbName).contains(new Point2d(point[0], point[1]));
            return true;
        }
        return false;
    }

    public boolean search(String dbName) {
        System.out.println("search");
        if(!treeMap.isEmpty() && treeMap.containsKey(dbName)) {
            treeMap.get(dbName).search();
            return true;
        }
        return false;
    }

    public boolean printTree(String dbName) {
        System.out.println("print tree");
        if(!treeMap.isEmpty() && treeMap.containsKey(dbName)) {
            treeMap.get(dbName).printTree();
            return true;
        }
        return false;
    }

    public boolean searchAboveTo(String dbName, int bottomBorder) {
        System.out.println("search above to");
        if(!treeMap.isEmpty() && treeMap.containsKey(dbName)) {
            treeMap.get(dbName).searchAboveTo(bottomBorder);
            return true;
        }
        return false;
    }

    public boolean searchNN(String dbName, int[] point) {
        System.out.println("search nn");
        if(!treeMap.isEmpty() && treeMap.containsKey(dbName)) {
            treeMap.get(dbName).searchNearestNeighbor(new Point2d(point[0], point[1]));
            return true;
        }
        return false;
    }

    public boolean searchInside(String dbName, int[] point1, int[] point2) {
        System.out.println("search inside");
        if(!treeMap.isEmpty() && treeMap.containsKey(dbName)) {
            treeMap.get(dbName).searchInside(new Point2d(point1[0], point1[1]), new Point2d(point2[0], point2[1]));
            return true;
        }
        return false;
    }
}
