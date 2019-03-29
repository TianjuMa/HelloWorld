package LaiOffer.DesignPattern.FactoryPattern.CommonFactory;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType) {
            case "Rectangle":
                return new Rectangle();
            case "Circle":
                return new Circle();
            default:
                return null;
        }
    }
}
