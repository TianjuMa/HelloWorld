package LaiOffer.DesignPattern.FactoryPattern;

import LaiOffer.DesignPattern.FactoryPattern.CommonFactory.Shape;
import LaiOffer.DesignPattern.FactoryPattern.CommonFactory.ShapeFactory;

public class FactoryPatternDemo {
    private static final ShapeFactory shapeFactory = new ShapeFactory();

    public static void main(String[] args) {
        Shape shape0 = shapeFactory.getShape(null);
        System.out.println(shape0);

        Shape shape1 = shapeFactory.getShape("Rectangle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Circle");
        shape2.draw();
    }
}
