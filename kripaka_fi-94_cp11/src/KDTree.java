import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class KDTree {
    private int size = 0;
    Point2d head;

    public KDTree() {
        head = null;
    }

    public void add(Point2d point) {
        Point2d current = head;
        add(point, head, true);
    }

    private boolean add(Point2d point2d, Point2d node, boolean isXComparable) {
        if (size == 0 && node == head && head == null) {
            head = point2d;
            size++;
        } else if (isXComparable && point2d.getX() < node.getX()) {
            if (node.left == null) {
                node.left = point2d;
                size++;
            } else add(point2d, node.left, false);
        } else if (isXComparable) {
            if (node.right == null) {
                node.right = point2d;
                size++;
            } else add(point2d, node.right, false);

        } else if (!isXComparable && point2d.getY() < node.getY()) {
            if (node.left == null) {
                node.left = point2d;
                size++;
            } else add(point2d, node.left, true);

        } else if (!isXComparable) {
            if (node.right == null) {
                node.right = point2d;
                size++;
            } else add(point2d, node.right, true);
        }
        return true;
    }


    public void printTree() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(50);
        head.print(builder, "", "");

        return builder.toString();
    }


    public boolean contains(Point2d point) {
        if (size > 0)
            return head.contains(point, true);
        return false;
    }

    public List<Point2d> search() {
        return Arrays.asList(null, null);
    }

    public List<Point2d> searchInside(Point2d point2d, Point2d d) {
        return Arrays.asList(null, null);
    }

    public List<Point2d> searchAboveTo(int bottomBorder) {
        return Arrays.asList(null, null);
    }

    public void removeAll() {

    }

    public Point2d peek() {
        return new Point2d(0, 0);
    }

    public Point2d remove() {
        return new Point2d(0, 0);
    }

    public List<Point2d> searchNearestNeighbor(Point2d point) {
        return Arrays.asList(null, null);
    }

}
