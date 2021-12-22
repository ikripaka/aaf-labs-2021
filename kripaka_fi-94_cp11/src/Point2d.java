import java.awt.geom.Point2D;
import java.util.Iterator;

public class Point2d {
    private int xCoordinate, yCoordinate;
    protected Point2d left, right;

    public void Point2d(int x, int y, Point2d left, Point2d right) {
        xCoordinate = x;
        yCoordinate = y;
        this.left = left;
        this.right = right;

    }

    public Point2d(int x, int y) {
        Point2d(x, y, null, null);
    }           // construct the point (x, y)

    public int getX() {
        return xCoordinate;
    }            // x-coordinate

    public int getY() {
        return yCoordinate;
    }            // y-coordinate

    boolean isNodeHasChildren() {
        return left != null || right != null;
    }

    public double distanceTo(Point2d that) {
        return 0;

    }         // Euclidean distance between two points

    public double distanceSquaredTo(Point2d that) {
        return 0;
    }  // square of Euclidean distance between two points

    public int compareTo(Point2d that) {
        return 0;
    } // for use in an ordered symbol table

    public boolean equals(Object that) {
        return ((Point2d) that).xCoordinate == xCoordinate && ((Point2d) that).yCoordinate == yCoordinate;
    } // does this point equal that object?


    @Override
    public String toString() {
        return "(" + xCoordinate + ", " + yCoordinate + ")";
    }

    public void print(StringBuilder builder, String prefix, String childrenPrefix) {
        builder.append(prefix);
        builder.append(toString());
        builder.append('\n');
        if (left == null && right != null) {
            right.print(builder, childrenPrefix + "└── ", childrenPrefix + "    ");
        } else {
            if (left != null) {
                left.print(builder, childrenPrefix + "├── ", childrenPrefix + "│   ");
            }
            if (right != null) {
                right.print(builder, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    public boolean contains(Point2d point, boolean isXComparable) {
        boolean comparison = point.getX() == xCoordinate && point.getY() == yCoordinate;
        if (comparison) return true;
//        System.out.println(isXComparable && point.getX() < getX() && left != null left.contains(point, false));
//        System.out.println(isXComparable && point.getX() >= getX() && left != null && left.contains(point, false));
//        System.out.println(!isXComparable && point.getY() < getY() && right != null && right.contains(point, true));
//        System.out.println(!isXComparable && point.getY() >= getY() && right != null && right.contains(point, true));
        if (isXComparable && point.getX() < getX() && left != null){
            return left.contains(point, false);
        }
        if (isXComparable && point.getX() >= getX() && left != null){
            return right.contains(point, false);
        }
        if (!isXComparable && point.getY() < getY() && right != null ){
            return left.contains(point, true);
        }
        if (!isXComparable && point.getY() >= getY() && right != null){
            return right.contains(point, true);
        }
        // no matching node was found
        return false;
    }
}
