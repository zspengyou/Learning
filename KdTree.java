import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private static final boolean VERTICAL = true;
    private static final boolean HORIZONTAL = false;
    private static final boolean LEFT = true;
    private static final boolean RIGHT = false;
    private Node root;
    private int size;

    // construct an empty set of points
    public KdTree() {
    }

    // is the set empty?
    public boolean isEmpty() {
        return root == null;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D point) {
        if (contains(point))
            return;
        size++;
        root = put(root, point, VERTICAL, new RectHV(0, 0, 1, 1));
    }

    private Node put(Node node, Point2D point, boolean orientation, RectHV rectHV) {
        if (node == null) {
            return new Node(point, orientation, rectHV);
        }
        if (node.point.equals(point))
            return node;
        if (node.comparePoint(point) < 0) {
            node.left = put(node.left, point, node.nextOrientation(), node.nextRectHV(LEFT));
        } else {
            node.right = put(node.right, point, node.nextOrientation(), node.nextRectHV(RIGHT));
        }
        return node;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (isEmpty())
            return false;
        Node node = root;
        while (node != null) {
            if (node.point.equals(p)) {
                return true;
            }
            if (node.comparePoint(p) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    // draw all points to standard draw
    public void draw() {
        preOrderDraw(root);
    }

    private void preOrderDraw(Node node) {
        if (node == null)
            return;
        node.draw();
        preOrderDraw(node.left);
        preOrderDraw(node.right);
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        List<Point2D> result = new ArrayList<>();
        rangeSearch(rect, root, result);
        return result;
    }

    private void rangeSearch(RectHV rect, Node node, List<Point2D> result) {
        if (node == null)
            return;
        if (rect.contains(node.point))
            result.add(node.point);
        if (rect.intersects(node.nextRectHV(LEFT))) {
            rangeSearch(rect, node.left, result);
        }
        if (rect.intersects(node.nextRectHV(RIGHT))) {
            rangeSearch(rect, node.right, result);
        }
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (isEmpty())
            return null;
        Point2D result = nearestSearch(root, p, Double.MAX_VALUE);
        return result;
    }

    private Point2D nearestSearch(Node node, Point2D targetPoint, Double minDist) {
        if (node == null)
            return null;
        Point2D resultPoint = null;
        Point2D currentPoint = node.point;
        Helper helper = updateResult(currentPoint, targetPoint, resultPoint, minDist);
        minDist = helper.dist;
        resultPoint = helper.point;

        RectHV containPointRect = node.nextRectHV(LEFT);
        RectHV notContainPointRect = node.nextRectHV(RIGHT);
        Node containPointNode = node.left;
        Node notContainPointNode = node.right;
        if (notContainPointRect.contains(targetPoint)) {
            containPointNode = node.right;
            notContainPointNode = node.left;
            notContainPointRect = node.nextRectHV(LEFT);
            containPointRect = node.nextRectHV(RIGHT);
        }

        double minDistC = containPointRect.distanceSquaredTo(targetPoint);
        if(minDistC < minDist){
            currentPoint = nearestSearch(containPointNode, targetPoint, minDist);
            helper = updateResult(currentPoint, targetPoint, resultPoint, minDist);
            minDist = helper.dist;
            resultPoint = helper.point;
        }


        Double minDistR = notContainPointRect.distanceSquaredTo(targetPoint);
        if (minDistR < minDist) {
            currentPoint = nearestSearch(notContainPointNode, targetPoint, minDist);
            helper = updateResult(currentPoint, targetPoint, resultPoint, minDist);
            minDist = helper.dist;
            resultPoint = helper.point;
        }

        return resultPoint;
    }

    private Helper updateResult(Point2D currentPoint, Point2D targetPoint, Point2D resultPoint, Double minDist) {
        if (currentPoint == null)
            return new Helper(minDist, resultPoint);
        Double dist = currentPoint.distanceSquaredTo(targetPoint);
        if (dist < minDist) {
            resultPoint = currentPoint;
            minDist = dist;
        }
        return new Helper(minDist, resultPoint);
    }

    private class Helper {
        double dist;
        Point2D point;

        public Helper(double dist, Point2D point) {
            this.dist = dist;
            this.point = point;
        }
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        try {
            NearestNeighborVisualizer.main(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Node {
        public Point2D point;
        public boolean orientation;
        public RectHV rectHV;
        public Node left;
        public Node right;

        public Node(Point2D point, boolean orientation, RectHV rectHV) {
            this.point = point;
            this.orientation = orientation;
            this.rectHV = rectHV;
        }

        public int comparePoint(Point2D q) {
            if (orientation == VERTICAL) {
                return Point2D.X_ORDER.compare(q, point);
            } else {
                return Point2D.Y_ORDER.compare(q, point);
            }
        }

        public boolean nextOrientation() {
            return orientation == VERTICAL ? HORIZONTAL : VERTICAL;
        }

        public void draw() {
            StdDraw.setPenRadius();
            if (orientation == VERTICAL) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(point.x(), rectHV.ymin(), point.x(), rectHV.ymax());
                StdDraw.setPenRadius(0.2);
                StdDraw.point(point.x(), point.y());
            } else {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.line(rectHV.xmin(), point.y(), rectHV.xmax(), point.y());
                StdDraw.setPenRadius(0.2);
                StdDraw.point(point.x(), point.y());
            }
        }

        public RectHV nextRectHV(boolean orientation2) {
            if (orientation == VERTICAL) {
                if (orientation2 == LEFT) {
                    return new RectHV(rectHV.xmin(), rectHV.ymin(), point.x(), rectHV.ymax());
                } else {
                    return new RectHV(point.x(), rectHV.ymin(), rectHV.xmax(), rectHV.ymax());
                }
            } else {
                if (orientation2 == LEFT) {
                    return new RectHV(rectHV.xmin(), rectHV.ymin(), rectHV.xmax(), point.y());
                } else {
                    return new RectHV(rectHV.xmin(), point.y(), rectHV.xmax(), rectHV.ymax());
                }
            }
        }

        public String toString() {
            return point.toString() + orientation;
        }
    }

}