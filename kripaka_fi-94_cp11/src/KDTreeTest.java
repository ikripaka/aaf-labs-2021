import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class KDTreeTest {
    KDTree kdTree = new KDTree();

    @Test
    void addTest(){
        kdTree.add(new Point2d(5,5));
        kdTree.add(new Point2d(7,5));
        kdTree.add(new Point2d(8,6));
        kdTree.add(new Point2d(8,2));
        kdTree.add(new Point2d(2,6));
        kdTree.add(new Point2d(-2,8));
        kdTree.add(new Point2d(6,3));
        kdTree.add(new Point2d(4,-10));
        kdTree.add(new Point2d(9,6));
        kdTree.add(new Point2d(5,-5));
        kdTree.add(new Point2d(2,9));
        kdTree.add(new Point2d(7,-4));
        kdTree.add(new Point2d(-5,3));
        kdTree.add(new Point2d(9,1));

        System.out.println(kdTree.contains(new Point2d(5,-5)));
        System.out.println(kdTree.contains(new Point2d(5,-5)));
        System.out.println(kdTree.contains(new Point2d(5,-5)));
        System.out.println(kdTree.contains(new Point2d(11,-6)));
        System.out.println(kdTree.contains(new Point2d(9,1)));
        System.out.println(kdTree.contains(new Point2d(-2,8)));
        System.out.println(kdTree.contains(new Point2d(7,5)));
        System.out.println(kdTree.contains(new Point2d(4,-10)));
        System.out.println(kdTree.contains(new Point2d(8,2)));

        kdTree.printTree();
    }

    @Test
    void foreach(){


    }

}
