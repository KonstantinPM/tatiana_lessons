package task6;

import java.util.*;

public class MyUtils {
    public static List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> shapesCopy = new ArrayList<>(shapes);
        List<Shape> maxShapes = new ArrayList<>();
        double maxArea = Double.MIN_VALUE;
        if (shapes==null || shapes.isEmpty()){
           return Collections.emptyList();
        }
        Set<Integer> addedObjectHashCodes = new HashSet<>();

        for (Shape shape : shapesCopy) {
            double area = shape.getArea();
            if (area > maxArea) {
                maxShapes.clear();
                maxShapes.add(shape);
                maxArea = area;
                addedObjectHashCodes.clear();
                addedObjectHashCodes.add(System.identityHashCode(shape));
            } else if (area == maxArea) {
                int objectHashCode = System.identityHashCode(shape);
                if (!addedObjectHashCodes.contains(objectHashCode)) {
                    maxShapes.add(shape);
                    addedObjectHashCodes.add(objectHashCode);
                }
            }
        }

        if (maxShapes.isEmpty() && !shapesCopy.isEmpty()) {
            // if no shapes have been added to maxShapes and the input list is not empty,
            // then the input list contains only one shape, which should be returned
            maxShapes.add(shapesCopy.get(0));
        }

        return maxShapes;
    }
}