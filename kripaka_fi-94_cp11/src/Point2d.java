import java.util.Iterator;

public class Point2d {
    public int xCoordinate, yCoordinate;
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

    public int x() {
        return xCoordinate;
    }            // x-coordinate

    public int y() {
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
            if(left != null){
                left.print(builder, childrenPrefix + "├── ", childrenPrefix + "│   ");
            }
            if(right != null){
                right.print(builder, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}
